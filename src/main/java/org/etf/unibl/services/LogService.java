package org.etf.unibl.services;

import org.etf.unibl.models.entities.LogEntity;

import java.util.List;

public interface LogService {
    List<LogEntity> getAll();
}
