package com.anatomica.market.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Client")
@Data
@Getter
@NoArgsConstructor
public class Client implements Serializable {
    private static final long serialVersionUID = 5830463446510949899L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "orderClient",
            joinColumns = @JoinColumn(name = "id_Client"),
            inverseJoinColumns = @JoinColumn(name = "id_Product")
    )
    private List<Product> products;

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return String.format("Покупатель: [id = %d, Name = %s]", id, name);
    }
}
