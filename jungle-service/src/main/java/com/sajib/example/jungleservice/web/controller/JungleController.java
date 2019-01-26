package com.sajib.example.jungleservice.web.controller;

import com.sajib.example.jungleservice.service.AnimalServiceClient;
import com.sajib.example.jungleservice.service.BirdServiceClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

/**
 * Created by sajib on 1/25/19.
 */
@RestController
public class JungleController {

    private static final Logger LOG = Logger.getLogger(JungleController.class.getName());

    private AnimalServiceClient animalServiceClient;
    private BirdServiceClient birdServiceClient;

    public JungleController(AnimalServiceClient animalServiceClient, BirdServiceClient birdServiceClient) {
        this.animalServiceClient = animalServiceClient;
        this.birdServiceClient = birdServiceClient;
    }

    @RequestMapping
    public String index(HttpServletRequest request) {

        String response = new StringBuilder().append(animalServiceClient.getAllAnimalsResponse())
                .append(" ").append(birdServiceClient.getAllBirdsResponse()).toString();
        LOG.info("response: " + response);

        return response;
    }

}
