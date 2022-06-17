package org.etf.unibl.repositories;

import org.etf.unibl.models.entities.ContentEntity;
import org.etf.unibl.models.entities.MuseumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<ContentEntity, Integer> {
}
