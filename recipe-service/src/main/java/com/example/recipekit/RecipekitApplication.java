package com.example.recipekit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan
public class RecipekitApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipekitApplication.class, args);
	}

}
