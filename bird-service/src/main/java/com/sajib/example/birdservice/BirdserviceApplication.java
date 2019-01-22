package com.sajib.example.birdservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by sajib on 1/22/19.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BirdserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BirdserviceApplication.class, args);
    }
}
