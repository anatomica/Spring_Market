package com.anatomica.market.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Cart {
    private Product product;
    private Integer qty;

    public Cart(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(product, cart.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
