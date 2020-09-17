package com.anatomica.market.entities;

import com.anatomica.market.services.CartService;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
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
    // @Cascade(org.hibernate.annotations.CascadeType.ALL)
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
        this.items = cartService.getItems();
//        this.items = new ArrayList<>();
//        for (OrderItem oi : cart.getItems()) {
//            oi.setOrder(this);
//            this.items.add(oi);
//        }
        this.price = new BigDecimal(cartService.getPrice().doubleValue());
        cartService.clear();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", items=" + items +
                ", price=" + price +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
