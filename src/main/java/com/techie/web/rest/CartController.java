package com.techie.web.rest;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.exceptions.product.*;
import com.techie.service.*;
import com.techie.utils.*;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.*;

import java.net.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @PostMapping("/items")
    public ResponseEntity<?> addToCart(@RequestBody CartItemDTO itemDTO, HttpServletRequest request) {
        try {
            String cartId = AnonymousCartIdentifier.getOrCreateIdentifier(request);
            Cart cart = cartService.getOrCreateCart(cartId);
            CartItemDTO createdItem = cartService.addItem(cart, itemDTO);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}") // Add the address ID to the path
                    .buildAndExpand(createdItem.getId())
                    .toUri();

            // Return 201 Created with the location of the new cartItem and the created item object
            return ResponseEntity.created(location).body(createdItem);
        } catch (NotEnoughInStockException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage()); // 409
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    @PatchMapping("/items/{itemId}")
    public ResponseEntity<String> updateCartItem(@PathVariable Long itemId, @RequestBody CartItemDTO itemDTO, HttpServletRequest request) {
        try {
            String cartId = AnonymousCartIdentifier.getOrCreateIdentifier(request);
            Cart cart = cartService.getOrCreateCart(cartId);
            cartService.updateItem(cart, itemId, itemDTO);

            return ResponseEntity.ok().body("Successfully updated quantity");
        } catch (NotEnoughInStockException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage()); // 409
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    @GetMapping("/cart/get")
    public ResponseEntity<?> getCart(HttpServletRequest request) {
        try {
            String cartId = AnonymousCartIdentifier.getOrCreateIdentifier(request);
            Cart cart = cartService.getOrCreateCart(cartId);
            return ResponseEntity.ok().body(cartService.getCartDTO(cart));
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }
}