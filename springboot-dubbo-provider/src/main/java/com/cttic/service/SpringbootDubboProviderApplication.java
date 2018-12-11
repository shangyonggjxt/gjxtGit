package com.cttic.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:dubbo-provider.xml"})
public class SpringbootDubboProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubboProviderApplication.class, args);
	}
}
