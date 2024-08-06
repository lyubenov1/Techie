package com.techie.web;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderViewController {

    private final OrderService orderService;

    @Autowired
    public OrderViewController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String showOrderConfirmation(@RequestParam("id") Long orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        OrderDTO orderDTO = orderService.convertToDTO(order);
        model.addAttribute("order", orderDTO);
        return "order";
    }
}
