package org.etf.unibl.controllers;

import org.etf.unibl.models.entities.MuseumEntity;
import org.etf.unibl.services.impl.MuseumServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@PreAuthorize("hasAuthority('USER')")
public class MuseumController {
    private final String CITY_QUERY = "city";
    private final String MUS_NAME_QUERY = "name";
    private final String ID_QUERY = "id";
    private final String EMPTY_STRING = "";

    private final MuseumServiceImpl museumService;

    public MuseumController(MuseumServiceImpl museumService) {
        this.museumService = museumService;
    }

    @GetMapping("/museums")
    List<MuseumEntity> getByParam(@RequestParam(value = CITY_QUERY, required = false, defaultValue = EMPTY_STRING) String city,
                                  @RequestParam(value = MUS_NAME_QUERY, required = false, defaultValue = EMPTY_STRING) String name,
                                  @RequestParam(value = ID_QUERY, required = false, defaultValue = EMPTY_STRING) String id) {

        //Requesting museum by id, if id is not empty
        if(!EMPTY_STRING.equals(id)){
            return Collections.singletonList(museumService.getMuseumById(Integer.parseInt(id)));
        }
        //Request without parameters, return all museums
        if (EMPTY_STRING.equals(city) && EMPTY_STRING.equals(name)) {
            return museumService.getAll();
        }
        //Request for museums by specific city, no name provided
        else if (EMPTY_STRING.equals(name)) {
            return museumService.getMuseumsByCity(city);
        }
        //Request for muesums by their name, no city specified
        else if (EMPTY_STRING.equals(city)) {
            return museumService.getMuseumsByName(name);
        }
        //Request for museums by city and name
        else {
            return museumService.getMuseumsByCityAndName(city, name);
        }
    }
}