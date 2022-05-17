package org.etf.unibl.repositories;

import org.etf.unibl.models.entities.MuseumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuseumRepository extends JpaRepository<MuseumEntity, Integer> {
}
