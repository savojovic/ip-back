package org.etf.unibl.models.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "museum", schema = "ip", catalog = "")
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
    @Basic
    @Column(name = "address_id_address")
    private Integer addressIdAddress;
}
