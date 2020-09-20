package com.anatomica.market.entities;

import com.anatomica.market.services.CartService;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<OrderItem> items;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "phone_number")
    private String phone;

    @Column(name = "address")
    private String address;

    public Order(User user, CartService cartService, String phone, String address) {
        this.user = user;
        this.phone = phone;
        this.address = address;
        this.items = new ArrayList<>();
        this.items = cartService.getItems();
//        for (OrderItem oi : cartService.getItems()) {
//            oi.setOrder(this);
//            this.items.add(oi);
//        }
        this.price = new BigDecimal(cartService.getPrice().doubleValue());
    }

}
