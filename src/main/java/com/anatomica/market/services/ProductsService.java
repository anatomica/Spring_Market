package com.anatomica.market.services;

import com.anatomica.market.beans.AppLoggingAspect;
import com.anatomica.market.entities.Category;
import com.anatomica.market.entities.Product;
import com.anatomica.market.entities.dtos.ProductDto;
import com.anatomica.market.exceptions.ProductNotFoundException;
import com.anatomica.market.repositories.CategoriesRepository;
import com.anatomica.market.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product saveOrUpdate(Product product) {
        AppLoggingAspect.logger.info("Обновлен или создан продукт");
        return productsRepository.save(product);
    }

    public Product findById(Long id) {
        AppLoggingAspect.logger.info("Поиск одного товара");
        return productsRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Can't found product with id = " + id));
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public Page<Product> findAll(Specification<Product> spec, Integer page) {
        AppLoggingAspect.logger.info("Запрос на список всех товаров");
        if (page < 1L) {
            page = 1;
        }
        return productsRepository.findAll(spec, PageRequest.of(page - 1, 10));
    }

    public void deleteAll() {
        AppLoggingAspect.logger.info("Удалено ВСЕ");
        productsRepository.deleteAll();
    }

    public void deleteById(Long id) {
        AppLoggingAspect.logger.info("Удален один товар");
        productsRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        AppLoggingAspect.logger.info("Запрос на наличие товара в БД");
        return productsRepository.existsById(id);
    }

    public List<ProductDto> getDtoData() {
        AppLoggingAspect.logger.info("Запрос ДТО");
        return productsRepository.findAllBy();
    }
}
