package com.sajib.example.jungleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by sajib on 1/22/19.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class JungleserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(JungleserviceApplication.class, args);
    }
}
