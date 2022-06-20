package org.etf.unibl.services.impl;

import lombok.AllArgsConstructor;
import org.etf.unibl.models.entities.LogEntity;
import org.etf.unibl.repositories.LogRepository;
import org.etf.unibl.services.LogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LogServiceImpl implements LogService {
    private final LogRepository repository;

    @Override
    public List<LogEntity> getAll() {
        return repository.findAll();
    }
}
