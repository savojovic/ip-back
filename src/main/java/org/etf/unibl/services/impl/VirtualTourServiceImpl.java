package org.etf.unibl.services.impl;

import lombok.AllArgsConstructor;
import org.etf.unibl.models.entities.ContentEntity;
import org.etf.unibl.models.entities.VirtualtourEntity;
import org.etf.unibl.repositories.ContentRepository;
import org.etf.unibl.repositories.MuseumRepository;
import org.etf.unibl.repositories.VirtualTourRepository;
import org.etf.unibl.services.VirtualTourService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;

@Service
@AllArgsConstructor
public class VirtualTourServiceImpl implements VirtualTourService {

    private final VirtualTourRepository virtualTourRepository;
    private final ContentRepository contentRepository;
    private final MuseumRepository museumRepository;

    @Override
    public void createVirtualTour(JSONObject virtualTour) {
        ContentEntity content = getContent(virtualTour);
        VirtualtourEntity virtualtourEntity = getVirtualTour(virtualTour);
        contentRepository.save(content);
        virtualtourEntity.setContent(content);
        virtualTourRepository.save(virtualtourEntity);
    }
    private VirtualtourEntity getVirtualTour(JSONObject virtualTour){
        VirtualtourEntity virtualtour = new VirtualtourEntity();

        virtualtour.setDuration(virtualTour.getString("duration"));
        virtualtour.setMuseum(museumRepository.getById(virtualTour.getInt("museum_id")));
        virtualtour.setStartDate(Date.valueOf(virtualTour.getString("start_date")));
        return virtualtour;
    }
    private ContentEntity getContent(JSONObject virtualTour){
        ContentEntity content = new ContentEntity();
        content.setPic1(virtualTour.getString("pic1"));
        content.setPic2(virtualTour.getString("pic2"));
        content.setPic3(virtualTour.getString("pic3"));
        content.setPic4(virtualTour.getString("pic4"));
        content.setPic5(virtualTour.getString("pic5"));
        content.setVid(virtualTour.getString("vid"));
        return content;
    }
}
