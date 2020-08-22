package com.anatomica.market.entities.dtos;

import com.anatomica.market.entities.Product;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"product"})
@XmlRootElement(name = "getProductResponse")
public class GetProductResponse {

    @XmlElement(required = true)
    protected Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
