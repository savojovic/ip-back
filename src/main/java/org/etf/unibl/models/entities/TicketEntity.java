package org.etf.unibl.models.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ticket", schema = "ip", catalog = "")
public class TicketEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ticket_number")
    private Integer ticketNumber;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "museum_id")
    private String museumId;

}
