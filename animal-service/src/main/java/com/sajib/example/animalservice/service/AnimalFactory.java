package com.sajib.example.animalservice.service;

import com.sajib.example.animalservice.model.Animal;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sajib on 1/14/19.
 */
public class AnimalFactory {

    public static List<Animal> getAnimals() {
        List<Animal> animals = Arrays.asList(new Animal("Tiger", "Largest cat species"),
                new Animal("Lion", "King of jungle"));
        return animals;
    }
}

