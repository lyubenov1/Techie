package com.techie.web.rest;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.domain.model.requests.*;
import com.techie.exceptions.address.*;
import com.techie.exceptions.order.*;
import com.techie.service.*;
import com.techie.utils.*;
import jakarta.servlet.http.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.security.core.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.*;

import java.net.*;
import java.util.*;
import java.util.stream.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;
    private final CartService cartService;

    @Autowired
    public OrderController(OrderService orderService, CartService cartService) {
        this.orderService = orderService;
        this.cartService = cartService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> createOrder(@RequestBody @Valid OrderRequest orderRequest, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            String cartId = AnonymousCartIdentifier.getOrCreateIdentifier(request);
            Cart cart = cartService.getOrCreateCart(cartId);
            Order createdOrder = orderService.finishOrder(orderRequest, cart);
            OrderDTO orderDTO = orderService.convertToDTO(createdOrder);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdOrder.getId())
                    .toUri();

            return ResponseEntity.created(location).body(orderDTO);
        } catch (AddressNotFoundException e) {
            return ResponseEntity.badRequest().body(Collections.singletonList("Invalid address"));
        } catch (InvalidOrderException e) {
            return ResponseEntity.badRequest().body(Collections.singletonList(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonList("An error occurred while processing your order"));
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getOrders(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam(name = "p", required = false) int page,
            @RequestParam(name = "s", required = false) int size) {
        try {
            Page<OrderDTO> orders = orderService.getOrderHistoryForUser(userDetails, page, size);
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }
}
