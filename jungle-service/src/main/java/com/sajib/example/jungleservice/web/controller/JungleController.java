package com.sajib.example.jungleservice.web.controller;

import com.sajib.example.jungleservice.service.JungleService;
import com.sajib.example.jungleservice.web.model.JungleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by sajib on 1/25/19.
 */
@RestController
public class JungleController {

    private static final Logger LOG = Logger.getLogger(JungleController.class.getName());

    @Autowired
    private JungleService jungleService;

    @RequestMapping("/")
    public JungleResponse getAllSpecies() {
        JungleResponse jungleResponse = jungleService.getAllSpecies();
        return jungleResponse;
    }
}
