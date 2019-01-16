package com.sajib.example.animalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AnimalserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalserviceApplication.class, args);
	}

}

