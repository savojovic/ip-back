package org.etf.unibl.services.impl;

import org.etf.unibl.models.entities.MuseumEntity;
import org.etf.unibl.repositories.MuseumRepository;
import org.etf.unibl.repositories.VirtualTourRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuseumServiceImpl {
    private final MuseumRepository repository;

    public MuseumServiceImpl(MuseumRepository repository) {
        this.repository = repository;
    }

    public List<MuseumEntity> getAll(){
        return repository.findAll();
    }

    public MuseumEntity getMuseumById(Integer id){
        Optional<MuseumEntity> museum = repository.findById(id);
        return museum.orElse(null);
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