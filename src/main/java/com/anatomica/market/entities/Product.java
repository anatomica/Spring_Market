package com.anatomica.market.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    @Column(name = "category_id")
    private int category_id;

//    @ManyToOne
//    @JoinColumn(name = "category_id" )
//    private Category category;

    public Product(Long id, String title, int price, int category_id) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category_id = category_id;
    }
}
