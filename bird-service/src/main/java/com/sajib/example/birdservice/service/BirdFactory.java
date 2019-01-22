package com.sajib.example.birdservice.service;

import com.sajib.example.birdservice.model.Bird;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sajib on 1/22/19.
 */
public class BirdFactory {

    public static List<Bird> getBirds() {
        List<Bird> birds = Arrays.asList(new Bird("Eagle", "Birds of prey"),
                new Bird("Kingfisher", "Brightly colored birds"));
        return birds;
    }
}
