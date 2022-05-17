package org.etf.unibl.services;

import org.etf.unibl.models.entities.MuseumEntity;
import org.etf.unibl.repositories.MuseumRepository;
import org.etf.unibl.repositories.VirtualTourRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuseumService {

    private final MuseumRepository repository;
    private final VirtualTourRepository tourRepository;

    public MuseumService(MuseumRepository repository, VirtualTourRepository tourRepository) {
        this.repository = repository;
        this.tourRepository = tourRepository;
    }

    public List<MuseumEntity> getAllMuseumsAndTours(){
        List<MuseumEntity> museums = repository.findAll();
        for(MuseumEntity museum : museums){
            VirtualTourRepository virtualTour = (VirtualTourRepository)tourRepository.getById(museum.getId());

        }
        return repository.findAll();
    }

}