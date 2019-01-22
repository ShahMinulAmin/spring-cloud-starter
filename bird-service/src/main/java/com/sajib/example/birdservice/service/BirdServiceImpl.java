package com.sajib.example.birdservice.service;

import com.sajib.example.birdservice.model.Bird;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sajib on 1/22/19.
 */
@Service
public class BirdServiceImpl implements BirdService {

    @Override
    public List<Bird> getAllBirds() {
        return BirdFactory.getBirds();
    }
}
