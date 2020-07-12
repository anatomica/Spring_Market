package com.anatomica.market.entities;

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

    @Column(name = "idCategory")
    private int idCategory;

    @Column(name = "nameCategory")
    private String  nameCategory;

    @ManyToMany
    @JoinTable(
            name = "products",
            joinColumns = @JoinColumn(name = "category")
            // , inverseJoinColumns = @JoinColumn(name = "category")
    )
    public List<Product> products;

    public Category(Long id, int idCategory, String nameCategory) {
        this.id = id;
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }
}

