package com.techie.web.rest;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
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
                    .buildAndExpand(createdItem.getId()) // Assuming addressDTO has an ID
                    .toUri();

            // Return 201 Created with the location of the new address and the created address object
            return ResponseEntity.created(location).body(createdItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }
    }

    @PatchMapping("/items/{itemId}")
    public ResponseEntity<CartDTO> updateCartItem(@PathVariable Long itemId,
                                                      @RequestBody CartItemDTO itemDTO,
                                                      HttpServletRequest request) {
        String cartId = AnonymousCartIdentifier.getOrCreateIdentifier(request);
        Cart cart = cartService.getOrCreateCart(cartId);
        cartService.updateItem(cart, itemId, itemDTO);
    }

    @GetMapping
    public ResponseEntity<CartDTO> getCart(HttpServletRequest request) {
        String cartId = AnonymousCartIdentifier.getOrCreateIdentifier(request);
        Cart cart = cartService.getOrCreateCart(cartId);
    }

    @DeleteMapping("/delete")
    public void clearCart(HttpServletRequest request) {
        String cartId = AnonymousCartIdentifier.getOrCreateIdentifier(request);
        Cart cart = cartService.getOrCreateCart(cartId);
        cartService.clearCart(cart);
    }

}