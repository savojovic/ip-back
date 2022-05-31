package org.etf.unibl.services.impl;

import lombok.AllArgsConstructor;
import org.etf.unibl.models.entities.MuseumTicketEntity;
import org.etf.unibl.repositories.MuseumTicketRepository;
import org.etf.unibl.services.MuseumTicketService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MuseumTicketServiceImpl implements MuseumTicketService {
    private final MuseumTicketRepository repository;

    @Override
    public void saveTicket(MuseumTicketEntity ticket) {
        repository.save(ticket);
    }
}
