package com.techie.events.listeners;

import com.techie.domain.entities.*;
import com.techie.events.*;
import com.techie.repository.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.event.*;

import java.util.*;

@Component
public class ProductPriceChangeListener {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductPriceChangeListener.class);


    @Autowired
    public ProductPriceChangeListener(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleProductPriceChange(ProductPriceChangeEvent event) {
        logger.info("Handling price change for product ID: {}", event.productId());

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
                item.recalculateTotalPrice();
                logger.debug("Recalculated price for cart item ID: {}", item.getId());

                Cart cart = item.getCart();
                cart.recalculateGrandTotal();
                cartRepository.save(cart);  // This will cascade save the CartItem as well
                logger.debug("Updated cart ID: {}", cart.getId());
            } catch (Exception e) {
                logger.error("Error updating cart item ID: {}", item.getId(), e);
            }
        }

        logger.info("Completed handling price change for product ID: {}", event.productId());
    }
}