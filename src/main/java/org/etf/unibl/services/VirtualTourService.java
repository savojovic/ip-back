package org.etf.unibl.services;

import org.etf.unibl.models.entities.VirtualtourEntity;
import org.json.JSONObject;

public interface VirtualTourService {
    void createVirtualTour(JSONObject virtualTour);
}
