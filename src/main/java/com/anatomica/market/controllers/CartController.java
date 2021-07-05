package com.anatomica.market.controllers;

import com.anatomica.market.beans.Cart;
import com.anatomica.market.entities.Product;
import com.anatomica.market.entities.dtos.OrderItemDto;
import com.anatomica.market.exceptions.ResourceNotFoundException;
import com.anatomica.market.services.OrderItemService;
import com.anatomica.market.services.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
public class CartController {
    private OrderItemService orderItemService;
    private ProductsService productsService;
    private Cart cart;

    @GetMapping
    public List<OrderItemDto> getCartContent() {
        return orderItemService.mapEntityListToDtoList(cart.getItems());
    }

    @GetMapping("/add/{productId}")
    public void addProductToCartById(@PathVariable Long productId) {
        Product product = productsService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Unable to add product (id = " + productId + " ) to cart. Product not found"));
        cart.add(product);
    }

    @GetMapping("/decrement/{productId}")
    public void decrementProductToCartById(@PathVariable Long productId) {
        cart.decrement(productsService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Unable to decrement product (id = " + productId + " ) in cart. Product not found")));
    }

    @GetMapping("/remove/{productId}")
    public void removeProductFromCartById(@PathVariable Long productId) {
        cart.removeByProductId(productId);
    }
}