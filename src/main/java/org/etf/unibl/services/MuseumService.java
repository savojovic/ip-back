package org.etf.unibl.services;

import org.etf.unibl.models.entities.MuseumEntity;

import java.util.List;

public interface MuseumService {
    MuseumEntity getMuseumById(Integer id);
    List<MuseumEntity> getMuseumsByCity(String city);
    List<MuseumEntity> getMuseumsByName(String name);
    List<MuseumEntity> getMuseumsByCityAndName(String city, String name);
    void saveMuseum(MuseumEntity museum);
}
