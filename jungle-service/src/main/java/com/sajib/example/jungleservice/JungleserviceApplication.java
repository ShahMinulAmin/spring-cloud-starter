package com.sajib.example.jungleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sajib on 1/22/19.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class JungleserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(JungleserviceApplication.class, args);
    }

    @Configuration
    static class MyConfig {
        @Bean
        @LoadBalanced
        public RestTemplate restTemplate() {
            return new RestTemplateBuilder().build();
        }

        @Bean
        public Sampler getSampler() {
            return new AlwaysSampler();
        }
    }
}
