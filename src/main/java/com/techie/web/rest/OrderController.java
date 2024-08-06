package com.techie.web.rest;

import com.techie.domain.entities.*;
import com.techie.domain.model.requests.*;
import com.techie.exceptions.address.*;
import com.techie.exceptions.order.*;
import com.techie.service.*;
import com.techie.utils.*;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> addOrder(@RequestBody OrderRequest orderRequest, HttpServletRequest request) {
        try {
            String cartId = AnonymousCartIdentifier.getOrCreateIdentifier(request);
            Cart cart = cartService.getOrCreateCart(cartId);
            orderService.finishOrder(orderRequest, cart);
            return ResponseEntity.ok("");
        } catch (AddressNotFoundException e) {
            return ResponseEntity.badRequest().body("Invalid address");
        } catch (InvalidOrderException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing your order");
        }
    }
}
