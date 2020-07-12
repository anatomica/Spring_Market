package com.anatomica.market.utils;

import com.anatomica.market.entities.Category;
import com.anatomica.market.entities.Product;
import com.anatomica.market.repositories.specifications.ProductSpecifications;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;
import java.util.Map;

@Getter
public class ProductFilter {
    public Specification<Product> spec;
    public Specification<Category> cat;
    public StringBuilder filterDefinition;

    public ProductFilter(Map<String, String> map) {
        this.spec = Specification.where(null);
        this.cat = Specification.where(null);
        this.filterDefinition = new StringBuilder();
        if (map.containsKey("min_price") && !map.get("min_price").isEmpty()) {
            int minPrice = Integer.parseInt(map.get("min_price"));
            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThan(minPrice));
            filterDefinition.append("&min_price=").append(minPrice);
        }
        if (map.containsKey("max_price") && !map.get("max_price").isEmpty()) {
            int maxPrice = Integer.parseInt(map.get("max_price"));
            spec = spec.and(ProductSpecifications.priceLesserOrEqualsThan(maxPrice));
            filterDefinition.append("&max_price=").append(maxPrice);
        }
        if (map.containsKey("like") && !map.get("like").isEmpty()) {
            String like = map.get("like");
            spec = spec.and(ProductSpecifications.titleLikeThis(like));
            filterDefinition.append("&like=").append(like);
        }
        if (map.containsKey("category") && !map.get("category").isEmpty()) {
            String category = map.get("category");
            spec = spec.and(ProductSpecifications.findByProducts(category));
            // cat = cat.and(ProductSpecifications.findByCategories(category));
            filterDefinition.append("&category=").append(category);
        }
    }
}
