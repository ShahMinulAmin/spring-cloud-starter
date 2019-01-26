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

    private AnimalServiceClient animalServiceClient;
    private BirdServiceClient birdServiceClient;

    public JungleServiceRestImpl(AnimalServiceClient animalServiceClient, BirdServiceClient birdServiceClient) {
        this.animalServiceClient = animalServiceClient;
        this.birdServiceClient = birdServiceClient;
    }

    @Override
    public JungleResponse getAllSpecies() {
        List<AnimalDTO> animalDTOList = animalServiceClient.getAllAnimalsResponse();
        LOG.info("animalDTOList: " + animalDTOList);
        List<BirdDTO> birdDTOList = birdServiceClient.getAllBirdsResponse();
        LOG.info("birdDTOList: " + birdDTOList);

        JungleResponse jungleResponse = new JungleResponse();
        jungleResponse.setAnimalDTOList(animalDTOList);
        jungleResponse.setBirdDTOList(birdDTOList);
        LOG.info("jungleResponse: " + jungleResponse);
        return jungleResponse;
    }
}
