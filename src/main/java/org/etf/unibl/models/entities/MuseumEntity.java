package org.etf.unibl.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "museum")
public class MuseumEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "geo_location")
    private String geoLocation;

    @ManyToOne
    @JoinColumn(name = "address_id_address", referencedColumnName = "id_address", nullable = false)
    private AddressEntity address;

    @OneToMany(mappedBy = "museum")
    private List<MuseumTicketEntity> museumtickets;

    @OneToMany(mappedBy = "museum")
    private List<VirtualtourEntity> virtualtours;

}
