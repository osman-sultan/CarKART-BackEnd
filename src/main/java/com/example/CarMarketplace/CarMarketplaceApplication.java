package com.example.CarMarketplace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarMarketplaceApplication {

	private static Logger LOG = LoggerFactory
			.getLogger(CarMarketplaceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarMarketplaceApplication.class, args);
		LOG.info("APPLICATION IS RUNNING");
	}

}
