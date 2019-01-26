package com.sajib.example.jungleservice.web.model;

import lombok.Data;

import java.util.List;

/**
 * Created by sajib on 1/26/19.
 */
@Data
public class JungleResponse {
    private List<AnimalDTO> animalDTOList;
    private List<BirdDTO> birdDTOList;
}
