package com.project.EcommercePurchasing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.project.EcommercePurchasing.Repository")
public class ECommercePurchasingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommercePurchasingApplication.class, args);
	}

}
