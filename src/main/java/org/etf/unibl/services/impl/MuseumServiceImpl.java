package org.etf.unibl.services.impl;

import org.etf.unibl.models.entities.MuseumEntity;
import org.etf.unibl.repositories.MuseumRepository;
import org.etf.unibl.repositories.VirtualTourRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuseumServiceImpl {

    private final VirtualTourRepository virtualTourRepository;
    private final MuseumRepository repository;

    public MuseumServiceImpl(VirtualTourRepository virtualTourRepository, MuseumRepository repository) {
        this.virtualTourRepository = virtualTourRepository;
        this.repository = repository;
    }

    public List<MuseumEntity> getAllMuseumsAndTours(){
       // List<MuseumEntity> museumEntities = repository.findAll();
        return repository.findAll();
    }

    public List<MuseumEntity> getMuseumsByCity(String city){
        return repository.findAllByAddress_City(city);
    }

    public List<MuseumEntity> getMuseumsByName(String name) {
        return repository.findAllByName(name);
    }
    public List<MuseumEntity> getMuseumsByCityAndName(String city, String name){
        return repository.findAllByAddress_CityAndName(city, name);
    }
}