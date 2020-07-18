package com.anatomica.market.controllers;

import com.anatomica.market.services.CartService;
import com.anatomica.market.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    public CartService cartService;
    public ProductsService productsService;

    @Autowired
    public CartController(CartService cartService, ProductsService productsService) {
        this.productsService = productsService;
        this.cartService = cartService;
    }

    @GetMapping
    public String showCart(Model model) {
        model.addAttribute("cart", cartService);
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, Model model) {
        model.addAttribute("cart", productsService.findById(id));
        cartService.addProductQty(productsService.findById(id), 1);
        return "redirect:/products";
    }

    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id) {
        cartService.removeProductQty(cartService.getLineItem().get(Math.toIntExact(id) - 1).getProduct(), 1);
        return "redirect:/cart";
    }

    @GetMapping("/removeAll/{id}")
    public String removeAllFromCart(@PathVariable Long id) {
        cartService.removeProductQty(cartService.getLineItem().get(Math.toIntExact(id) - 1).getProduct(), 1000);
        return "redirect:/cart";
    }
}