package com.sajib.example.jungleservice.service;

import com.sajib.example.jungleservice.web.model.AnimalDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by sajib on 1/26/19.
 */
public class AnimalServiceRestClientTests {

    private AnimalServiceRestClient animalServiceRestClient;

    @Before
    public void setup() {
        RestTemplate restTemplate = mock(RestTemplate.class);
        animalServiceRestClient = new AnimalServiceRestClient(restTemplate);
        List<AnimalDTO> animalDTOList = Arrays.asList(new AnimalDTO("Tiger", "Largest cat species"),
                new AnimalDTO("Lion", "King of jungle"));
        when(animalServiceRestClient.getAllAnimalsResponse()).thenReturn(animalDTOList);
    }

    @After
    public void teardown() {
        animalServiceRestClient = null;
    }

    @Test
    public void getAllAnimals() throws Exception {
        List<AnimalDTO> animalDTOList = animalServiceRestClient.getAllAnimalsResponse();
        assertEquals("Tiger", animalDTOList.get(0).getName());
        assertEquals("Lion", animalDTOList.get(1).getName());
    }
}
