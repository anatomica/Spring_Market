package com.anatomica.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketApplication {

	// products: http://127.0.0.1:8189/market/products

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}

}
