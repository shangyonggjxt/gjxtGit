package com.cttic.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CtticSpringboot2Application {

	public static void main(String[] args) {
		SpringApplication.run(CtticSpringboot2Application.class, args);
	}
}
