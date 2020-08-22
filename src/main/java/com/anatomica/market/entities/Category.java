package com.anatomica.market.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@Getter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_category")
    private String id_category;

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "category")
//    @JsonBackReference
//    List<Product> products;

//    @ManyToMany
//    @JoinTable(name = "products_categories",
//            joinColumns = @JoinColumn(name = "category_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    @JsonBackReference
//    private List<Product> products;

    public Category(String id_category, String name) {
        this.id_category = id_category;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

