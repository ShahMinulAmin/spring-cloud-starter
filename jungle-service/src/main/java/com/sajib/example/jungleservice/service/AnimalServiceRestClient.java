package com.sajib.example.jungleservice.service;

import com.sajib.example.jungleservice.web.model.AnimalDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by sajib on 1/26/19.
 */
@Service
public class AnimalServiceRestClient {

    private static final String ANIMAL_SERVICE_URL = "http://animal-service";
    private RestTemplate restTemplate;

    public AnimalServiceRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<AnimalDTO> getAllAnimalsResponse() {
        return restTemplate.getForObject(ANIMAL_SERVICE_URL, List.class);
    }
}
