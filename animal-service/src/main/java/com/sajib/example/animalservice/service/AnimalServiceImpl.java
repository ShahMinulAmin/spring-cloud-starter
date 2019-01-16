package com.sajib.example.animalservice.service;

import com.sajib.example.animalservice.model.Animal;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sajib on 1/14/19.
 */
@Service
public class AnimalServiceImpl implements AnimalService {
    @Override
    public List<Animal> getAllAnimals() {
        return AnimalFactory.getAnimals();
    }
}
