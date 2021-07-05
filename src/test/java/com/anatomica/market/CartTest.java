package com.anatomica.market;

import com.anatomica.market.services.CartService;
import com.anatomica.market.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("test")
public class CartTest {
    @Autowired
    private CartService cartService;

    @Test
    public void cartFillingTest() {
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            long productId = i / 2 + 1;
            product.setId(productId);
            product.setPrice(new BigDecimal(100 + productId * 10));
            product.setTitle("Product # " + productId);
            cartService.add(product);
        }
        Assertions.assertEquals(5, cartService.getItems().size());
        cartService.clear();
        Assertions.assertEquals(0, cartService.getItems().size());
    }
}