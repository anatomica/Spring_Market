package com.anatomica.market;

import com.anatomica.market.entities.Product;
import com.anatomica.market.repositories.ProductsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class RepositoriesTest {
    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void productRepositoryTest() {
        Product product = new Product("ProductTest", "ProductDesc", BigDecimal.valueOf(300));
        Product out = entityManager.persist(product);
        entityManager.flush();

        List<Product> productsList = productsRepository.findAll();

        Assertions.assertEquals(25, productsList.size());
        Assertions.assertEquals("ProductTest", productsList.get(24).getTitle());
    }

    @Test
    public void initDbTest() {
        List<Product> productsList = productsRepository.findAll();
        Assertions.assertEquals(24, productsList.size());
    }
}
