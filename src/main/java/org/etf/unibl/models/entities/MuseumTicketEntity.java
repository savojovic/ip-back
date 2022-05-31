package org.etf.unibl.models.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "museumticket")
public class MuseumTicketEntity {
    @Id
    @Column(name = "ticked_number")
    private Integer tickedNumber;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "surname")
    private String surname;

    @ManyToOne
    @JoinColumn(name = "museum_Id", referencedColumnName = "id", nullable = false)
    private MuseumEntity museum;

    public MuseumTicketEntity(Integer ticketNumber, MuseumEntity museum, String name, String surname) {
        this.tickedNumber=ticketNumber;
        this.museum = museum;
        this.name = name;
        this.surname = surname;
    }

    public MuseumTicketEntity() {

    }
}
