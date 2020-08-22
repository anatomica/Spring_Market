package com.anatomica.market.controllers;

import com.anatomica.market.entities.ws.GetProductRequest;
import com.anatomica.market.entities.ws.GetProductResponse;
import com.anatomica.market.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductsEndpoint {
    private static final String NAMESPACE_URI = "http://www.geekbrains.com/spring/ws/products";

    private ProductsRepository productsRepository;

    @Autowired
    public ProductsEndpoint(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProduct(@RequestPayload GetProductRequest request) {
        GetProductResponse response = new GetProductResponse();
        response.setProduct(productsRepository.getOne(request.getId()));
        return response;
    }

}
