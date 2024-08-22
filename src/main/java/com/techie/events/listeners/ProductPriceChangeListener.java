package com.techie.events.listeners;

import com.techie.domain.entities.*;
import com.techie.events.*;
import com.techie.repository.*;
import com.techie.service.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.transaction.event.*;

import java.util.*;

@Component
public class ProductPriceChangeListener {

    private final CartRepository cartRepository;
    private final CartService cartService;
    private final CartItemRepository cartItemRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductPriceChangeListener.class);


    @Autowired
    public ProductPriceChangeListener(CartRepository cartRepository, CartItemRepository cartItemRepository,
                                      CartService cartService) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartService = cartService;
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handleProductPriceChange(ProductPriceChangeEvent event) {
        List<CartItem> affectedCartItems;
        try {
            affectedCartItems = cartItemRepository.findByProductId(event.productId());
            logger.info("Found {} cart items affected by price change", affectedCartItems.size());
        } catch (Exception e) {
            logger.error("Error fetching affected cart items for product ID: {}", event.productId(), e);
            return;
        }

        for (CartItem item : affectedCartItems) {
            try {
                cartService.calculateTotalPrice(item);
                Cart cart = cartRepository.findByCartItem(item);
                cartService.calculateGrandTotal(cart);

                cartItemRepository.save(item);
                cartRepository.save(cart);
            } catch (Exception e) {
                logger.error("Error updating cart item ID: {}", item.getId(), e);
            }
        }
    }
}