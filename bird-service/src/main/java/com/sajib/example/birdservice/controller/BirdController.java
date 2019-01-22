package com.sajib.example.birdservice.controller;

import com.sajib.example.birdservice.model.Bird;
import com.sajib.example.birdservice.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by sajib on 1/22/19.
 */
@RestController
public class BirdController {
    private static final Logger LOG = Logger.getLogger(BirdController.class.getName());

    @Autowired
    BirdService birdService;

    @RequestMapping("/")
    public List<Bird> getAllBirds() {
        LOG.info("Getting list of all birds");
        return birdService.getAllBirds();
    }
}
