package com.sajib.example.jungleservice.service;

import com.sajib.example.jungleservice.web.model.AnimalDTO;
import com.sajib.example.jungleservice.web.model.BirdDTO;
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
public class BirdServiceRestClientTests {

    private BirdServiceRestClient birdServiceRestClient;

    @Before
    public void setup() {
        RestTemplate restTemplate = mock(RestTemplate.class);
        birdServiceRestClient = new BirdServiceRestClient(restTemplate);
        List<BirdDTO> birdDTOList = Arrays.asList(new BirdDTO("Eagle", "Birds of prey"),
                new BirdDTO("Kingfisher", "Brightly colored birds"));
        when(birdServiceRestClient.getAllBirdsResponse()).thenReturn(birdDTOList);
    }

    @After
    public void teardown() {
        birdServiceRestClient = null;
    }

    @Test
    public void getAllBirds() throws Exception {
        List<BirdDTO> birdDTOList = birdServiceRestClient.getAllBirdsResponse();
        assertEquals("Eagle", birdDTOList.get(0).getName());
        assertEquals("Kingfisher", birdDTOList.get(1).getName());
    }
}
