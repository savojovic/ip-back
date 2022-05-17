package org.etf.unibl.models.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address", schema = "ip", catalog = "")
public class AddressEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_address")
    private Integer idAddress;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "region")
    private String region;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "number")
    private String number;

}
