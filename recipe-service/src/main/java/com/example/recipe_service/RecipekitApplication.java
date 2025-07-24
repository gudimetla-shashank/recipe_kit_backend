package com.example.recipe_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class RecipekitApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipekitApplication.class, args);
	}

}
