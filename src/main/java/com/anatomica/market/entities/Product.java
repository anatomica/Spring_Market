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

    @Column(name = "category")
    private int category;

    @ManyToMany
    @JoinTable(
            name = "categories",
            joinColumns = @JoinColumn(name = "idCategory")
            // , inverseJoinColumns = @JoinColumn(name = "idCategory")
    )
    public List<Category> categories;

    public Product(Long id, String title, int price, int category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
    }
}
