package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.domain.model.requests.*;
import com.techie.exceptions.address.*;
import com.techie.exceptions.order.*;
import com.techie.exceptions.product.*;
import com.techie.repository.*;
import com.techie.utils.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.math.*;
import java.util.*;
import java.util.stream.*;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final UserService userService;
    private final AddressService addressService;
    private final ProductService productService;
    private final MailService mailService;
    private final OrderItemRepository orderItemRepository;
    private final ProductImageRepository productImageRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CartService cartService,
                        UserService userService, AddressService addressService, MailService mailService,
                        OrderItemRepository orderItemRepository, ProductImageRepository productImageRepository,
                        ProductService productService) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.userService = userService;
        this.addressService = addressService;
        this.mailService = mailService;
        this.orderItemRepository = orderItemRepository;
        this.productImageRepository = productImageRepository;
        this.productService = productService;
    }

    @Transactional
    public Order finishOrder(OrderRequest orderRequest, Cart cart) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Order order;

        if (orderRequest.getTotal().compareTo(BigDecimal.ZERO) == 0) {
            throw new InvalidOrderException("You can't place an empty order!");
        }

        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
            // Authenticated user
            User authUser = (User) auth.getPrincipal();
            UserEntity user = userService.findByUsernameNoFetches(authUser.getUsername());
            order = finishAuthenticatedOrder(orderRequest, cart, user);
        } else {
            // Unauthenticated user
            order = finishAnonymousOrder(orderRequest, cart);
        }
        return order;
    }

    private Order finishAuthenticatedOrder(OrderRequest orderRequest, Cart cart, UserEntity user) {
        Order order = createOrder(orderRequest, cart);
        order.setUserEmail(user.getEmail());

        if (orderRequest.getAddressId() != null) {
            Address address = addressService.findById(orderRequest.getAddressId())
                    .orElseThrow(() -> new AddressNotFoundException(orderRequest.getAddressId()));
            order.setDeliveryAddress(address);
        } else {
            throw new InvalidOrderException("No delivery address provided");
        }

        saveOrderAndClearCart(order, cart);
        initializeProductImages(order);
        mailService.sendOrderConfirmationEmail(user.getEmail(), order);
        return order;
    }

    private Order finishAnonymousOrder(OrderRequest orderRequest, Cart cart) {
        if (orderRequest.getAnonymousAddress() == null || orderRequest.getAnonymousAddress().isEmpty()) {
            throw new InvalidOrderException("No delivery address provided for anonymous order");
        }

        Order order = createOrder(orderRequest, cart);
        order.setAnonymousAddress(orderRequest.getAnonymousAddress());
        order.setUserEmail(orderRequest.getAnonymousEmail());

        saveOrderAndClearCart(order, cart);

        initializeProductImages(order);
        mailService.sendOrderConfirmationEmail(orderRequest.getAnonymousEmail(), order);
        return order;
    }

    private Order createOrder(OrderRequest orderRequest, Cart cart) {
        Order order = new Order();
        order.setGrandTotal(orderRequest.getTotal());
        order.setPaymentMethod(orderRequest.getPaymentMethod());

        List<OrderItem> orderItems = cart.getCartItems().stream()
                .map(cartItem -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrder(order);
                    orderItem.setProduct(cartItem.getProduct());
                    orderItem.setQuantity(cartItem.getQuantity());
                    orderItem.setTotalPrice(cartItem.getTotalPrice());
                    return orderItem;
                })
                .collect(Collectors.toList());

        order.setOrderItems(orderItems);
        return order;
    }

    private void saveOrderAndClearCart(Order order, Cart cart) {
        // Save the Order entity first
        Order savedOrder = orderRepository.save(order);

        // Update OrderItems with the saved Order
        order.getOrderItems().forEach(item -> item.setOrder(savedOrder));

        // Save the OrderItems
        List<OrderItem> savedOrderItems = orderItemRepository.saveAll(order.getOrderItems());
        savedOrder.setOrderItems(savedOrderItems);

        // Clear the cart
        cartService.deleteCart(cart);
    }

    private void initializeProductImages(Order order) {
        for (OrderItem item : order.getOrderItems()) {
            item.getProduct().setProductImages(
                    productImageRepository.findPrimaryImagesByProductId(item.getProduct().getId())
            );
        }
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findByOrderId(orderId).orElseThrow(OrderNotFoundException::new);
    }

    public OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = OrderConversionUtils.convertToDTO(order);

        // Set the product for each order item
        for (OrderItem orderItem : order.getOrderItems()) {
            Product product = productService.findById(orderItem.getProduct().getId())
                    .orElseThrow(() -> new ProductNotFoundException(orderItem.getProduct().getId()));
            ProductDTO productDTO = productService.convertToDTO(product);

                // Find the corresponding OrderItemDTO and set its product
            orderDTO.getOrderItems().stream()
                    .filter(itemDTO -> itemDTO.getId().equals(orderItem.getId()))
                    .findFirst()
                    .ifPresent(itemDTO -> itemDTO.setProduct(productDTO));
        }

        return orderDTO;
    }

    public Page<OrderDTO> getOrderHistoryForUser(UserDetails userDetails, int page, int size) {
        UserEntity user = userService.findByUsernameNoFetches(userDetails.getUsername());
        String userEmail = user.getEmail();

        Pageable pageable = PageRequest.of(page, size);
        Page<Order> ordersPage = orderRepository.findAllByUserEmail(userEmail, pageable);

        List<OrderDTO> orderDTOs = ordersPage.getContent().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        long totalOrders = orderRepository.countByUserEmail(userEmail);

        return new PageImpl<>(orderDTOs, ordersPage.getPageable(), totalOrders);
    }
}