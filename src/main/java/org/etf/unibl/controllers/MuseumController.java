package org.etf.unibl.controllers;

import org.etf.unibl.models.entities.MuseumEntity;
import org.etf.unibl.models.entities.VirtualtourEntity;
import org.etf.unibl.services.impl.MuseumServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@PreAuthorize("hasAuthority('ADMIN')")
public class MuseumController {
    private final String CITY_QUERY = "city";


    private final MuseumServiceImpl museumService;

    public MuseumController(MuseumServiceImpl museumService) {
        this.museumService = museumService;
    }

    @GetMapping("/museums")
    List<MuseumEntity> getByParam(@RequestParam(value = "city", required = false, defaultValue = "") String city,
                                  @RequestParam(value = "name", required = false, defaultValue = "") String name){
        if("".equals(city)&& "".equals(name)){
            List<MuseumEntity> museums = museumService.getAllMuseumsAndTours();
            return museums;
        }else if("".equals(name)){
            return museumService.getMuseumsByCity(city);
        }else if("".equals(city)){
            return museumService.getMuseumsByName(name);
        }else{
            return museumService.getMuseumsByCityAndName(city, name);
        }
    }
    @GetMapping("/tours")
    List<VirtualtourEntity> getTours(){
        List<MuseumEntity> museumEntities = museumService.getAllMuseumsAndTours();
        MuseumEntity museum = museumEntities.get(0);
        List<VirtualtourEntity> tours = museum.getVirtualtours();
        return tours;
    }
}