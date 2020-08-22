package com.anatomica.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketApplication {

	// products: http://localhost:8189/market/#!/products
	// productsWS: http://localhost:8189/market/ws
	// swagger: http://localhost:8189/market/swagger-ui.html

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}

}
