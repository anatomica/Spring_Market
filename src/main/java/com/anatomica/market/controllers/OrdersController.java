package com.anatomica.market.controllers;

import com.anatomica.market.services.CartService;
import com.anatomica.market.entities.Order;
import com.anatomica.market.entities.User;
import com.anatomica.market.services.OrdersService;
import com.anatomica.market.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrdersController {
    private UsersService usersService;
    private OrdersService ordersService;
    private CartService cartService;

    @GetMapping("/create")
    public String createOrder(Principal principal, Model model) {
        User user = usersService.findByEmail(principal.getName()).get();
        model.addAttribute("user", user);
        return "order_info";
    }

    @PostMapping(value = "/confirm", produces = "application/json")
    public ResponseEntity<?> confirmOrder(Principal principal, @RequestParam String address, String phone) {
        User user = usersService.findByEmail(principal.getName()).get();
        Order order = new Order(user, cartService, phone, address);
        order = ordersService.saveOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

}
