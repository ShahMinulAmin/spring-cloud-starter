package com.sajib.example.jungleservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sajib.example.jungleservice.web.model.AnimalDTO;
import com.sajib.example.jungleservice.web.model.BirdDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sajib on 1/25/19.
 */
@Service
public class BirdServiceRestClient {

    private static final String BIRD_SERVICE_URL = "http://bird-service";
    private RestTemplate restTemplate;

    public BirdServiceRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getDefaultAllBirdsResponse")
    public List<BirdDTO> getAllBirdsResponse() {
        return restTemplate.getForObject(BIRD_SERVICE_URL, List.class);
    }

    public List<BirdDTO> getDefaultAllBirdsResponse() {
        return new ArrayList<>();
    }
}
