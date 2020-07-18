package com.anatomica.market.services;

import com.anatomica.market.entities.Cart;
import com.anatomica.market.entities.Product;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService implements Serializable {

    public Map<Cart, Integer> cartIntegerMap;

    public CartService() {
        cartIntegerMap = new HashMap<>();
    }

    public void addProductQty(Product product, int qty) {
        Cart cart = new Cart(product);
        cartIntegerMap.put(cart, cartIntegerMap.getOrDefault(cart, 0) + qty);
    }

    public void removeProductQty(Product product, int qty) {
        Cart cart = new Cart(product);
        int currentQty = cartIntegerMap.getOrDefault(cart, 0);
        if (currentQty - qty > 0) cartIntegerMap.put(cart, currentQty - qty);
        else cartIntegerMap.remove(cart);
    }

    public List<Cart> getLineItem() {
        cartIntegerMap.forEach(Cart::setQty);
        return new ArrayList<>(cartIntegerMap.keySet());
    }

}
