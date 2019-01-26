package com.sajib.example.jungleservice.service;

import com.sajib.example.jungleservice.web.model.AnimalDTO;
import com.sajib.example.jungleservice.web.model.BirdDTO;
import com.sajib.example.jungleservice.web.model.JungleResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by sajib on 1/26/19.
 */
@Service
public class JungleServiceRestImpl implements JungleService {
    private static final Logger LOG = Logger.getLogger(JungleServiceRestImpl.class.getName());

    private AnimalServiceRestClient animalServiceRestClient;
    private BirdServiceRestClient birdServiceRestClient;

    public JungleServiceRestImpl(AnimalServiceRestClient animalServiceRestClient, BirdServiceRestClient birdServiceRestClient) {
        this.animalServiceRestClient = animalServiceRestClient;
        this.birdServiceRestClient = birdServiceRestClient;
    }

    @Override
    public JungleResponse getAllSpecies() {
        List<AnimalDTO> animalDTOList = animalServiceRestClient.getAllAnimalsResponse();
        LOG.info("animalDTOList: " + animalDTOList);
        List<BirdDTO> birdDTOList = birdServiceRestClient.getAllBirdsResponse();
        LOG.info("birdDTOList: " + birdDTOList);

        JungleResponse jungleResponse = new JungleResponse();
        jungleResponse.setAnimalDTOList(animalDTOList);
        jungleResponse.setBirdDTOList(birdDTOList);
        LOG.info("jungleResponse: " + jungleResponse);
        return jungleResponse;
    }
}
