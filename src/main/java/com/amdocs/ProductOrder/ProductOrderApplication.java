package com.amdocs.ProductOrder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ProductOrderApplication {

	private static final Logger log = LoggerFactory.getLogger(ProductOrderApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProductOrderApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8084"));
		app.run(args);
		log.info("Mercy Jacqueline Trujillo Rodriguezzzzzz");
	}
}
