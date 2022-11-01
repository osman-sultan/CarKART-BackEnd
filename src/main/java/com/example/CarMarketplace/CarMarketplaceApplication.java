package com.example.CarMarketplace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CarMarketplaceApplication {

	private static Logger LOG = LoggerFactory
			.getLogger(CarMarketplaceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarMarketplaceApplication.class, args);
		LOG.info("APPLICATION IS RUNNING");
	}

}
