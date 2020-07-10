package com.anatomica.market.repositories;

import com.anatomica.market.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Product findOneByTitle(String title);
    Product findAllByTitleLike(String title);
    List<Product> findAllByPriceGreaterThan(int minCost);
    List<Product> findAllByPriceLessThan(int maxCost);
    List<Product> findAllByPriceGreaterThanAndPriceLessThan(int minCost, int maxCost);
}