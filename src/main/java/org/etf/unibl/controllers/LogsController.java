package org.etf.unibl.controllers;

import lombok.AllArgsConstructor;
import org.etf.unibl.models.entities.LogEntity;
import org.etf.unibl.services.LogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@PreAuthorize("hasAuthority('ADMIN')")
public class LogsController {

    private final LogService logService;

    @GetMapping("/logs")
    public List<LogEntity> getLogs(){
        return logService.getAll();
    }
}