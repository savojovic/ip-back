package org.etf.unibl.controllers;

import lombok.AllArgsConstructor;
import org.etf.unibl.services.VirtualTourService;
import org.json.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class VirtualTourController {

    private final VirtualTourService virtualTourService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/tour")
    void addVirtualTour(@RequestBody String virtualTourString){
        virtualTourService.createVirtualTour(new JSONObject(virtualTourString));
    }
}