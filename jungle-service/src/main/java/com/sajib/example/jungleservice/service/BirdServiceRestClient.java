package com.sajib.example.jungleservice.service;

import com.sajib.example.jungleservice.web.model.BirdDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public List<BirdDTO> getAllBirdsResponse() {
        return restTemplate.getForObject(BIRD_SERVICE_URL, List.class);
    }
}
