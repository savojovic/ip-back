package org.etf.unibl.repositories;

import org.etf.unibl.models.entities.VirtualtourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirtualTourRepository extends JpaRepository<VirtualtourEntity, Integer> {
}
