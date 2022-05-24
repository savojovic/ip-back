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
         return repository.findAll();
    }
}