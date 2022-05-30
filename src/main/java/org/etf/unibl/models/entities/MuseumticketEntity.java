package org.etf.unibl.models.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "museumticket", schema = "ip", catalog = "")
public class MuseumticketEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ticked_number")
    private Integer tickedNumber;
    @ManyToOne
    @JoinColumn(name = "user_Id", referencedColumnName = "id", nullable = false)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "museum_Id", referencedColumnName = "id", nullable = false)
    private MuseumEntity museumTicket;

}
