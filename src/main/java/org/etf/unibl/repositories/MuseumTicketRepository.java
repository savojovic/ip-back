package org.etf.unibl.repositories;

import org.etf.unibl.models.entities.MuseumTicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuseumTicketRepository extends JpaRepository<MuseumTicketEntity, Integer> {
}
