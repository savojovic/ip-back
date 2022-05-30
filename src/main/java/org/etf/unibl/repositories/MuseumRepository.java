package org.etf.unibl.repositories;

import org.etf.unibl.models.entities.MuseumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MuseumRepository extends JpaRepository<MuseumEntity, Integer> {
    List<MuseumEntity> findAllByAddress_City(String city);
    List<MuseumEntity> findAllByName(String name);
    List<MuseumEntity> findAllByAddress_CityAndName(String city, String name);
}