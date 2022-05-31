package org.etf.unibl.controllers;

import lombok.AllArgsConstructor;
import org.etf.unibl.models.entities.MuseumEntity;
import org.etf.unibl.models.entities.MuseumTicketEntity;
import org.etf.unibl.services.impl.MuseumServiceImpl;
import org.etf.unibl.services.impl.MuseumTicketServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//TODO: generate jwt without expiration for bank

@RestController
@AllArgsConstructor
//@PreAuthorize("hasAuthority('BANK')")
public class BankController {
    private final String TICKET_QUERY = "ticket";
    private final String MUSEUM_QUERY = "museum";
    private final String NAME_QUERY = "name";
    private final String SURNAME_QUERY = "surname";

    private final MuseumTicketServiceImpl museumTicketService;
    private final MuseumServiceImpl museumService;

    @PostMapping("/ticket")
    void saveTicket(@RequestParam(value = TICKET_QUERY) String ticketNumber,
                    @RequestParam(value = MUSEUM_QUERY) String museumId,
                    @RequestParam(value = NAME_QUERY) String name,
                    @RequestParam(value = SURNAME_QUERY) String surname
                    ){
        MuseumEntity museum = museumService.getMuseumById(Integer.parseInt(museumId));
        MuseumTicketEntity ticket = new MuseumTicketEntity(Integer.parseInt(ticketNumber),museum,name,surname);
        museumTicketService.saveTicket(ticket);
    }
}
