package org.etf.unibl.repositories;

import org.etf.unibl.models.entities.ContentEntity;
import org.etf.unibl.models.entities.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository  extends JpaRepository<LogEntity, Integer> {
}
