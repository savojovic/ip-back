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
    @Basic
    @Column(name = "user_Id")
    private Integer userId;
    @Basic
    @Column(name = "museum_Id")
    private Integer museumId;

}
