package org.etf.unibl.controllers;

import org.etf.unibl.models.entities.MuseumEntity;
import org.etf.unibl.services.impl.MuseumServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/museums")
public class MuseumController {

    private final MuseumServiceImpl museumService;

    public MuseumController(MuseumServiceImpl museumService) {
        this.museumService = museumService;
    }

    @GetMapping
    List<MuseumEntity> getAll(){
        return museumService.getAllMuseumsAndTours();
    }
}