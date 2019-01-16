package com.sajib.example.animalservice.controller;

import com.sajib.example.animalservice.model.Animal;
import com.sajib.example.animalservice.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by sajib on 1/14/19.
 */
@RestController
public class AnimalController {
    private static final Logger LOG = Logger.getLogger(AnimalController.class.getName());

    @Autowired
    AnimalService animalService;

    @RequestMapping("/")
    public List<Animal> getAllAnimals(){
        LOG.info("Getting list of all animals");
        return animalService.getAllAnimals();
    }

}
