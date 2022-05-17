package org.etf.unibl.models.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "virtualtour", schema = "ip", catalog = "")
public class VirtualtourEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tour")
    private Integer idTour;
    @Basic
    @Column(name = "start_date")
    private Timestamp startDate;
    @Basic
    @Column(name = "duration")
    private String duration;
    @Basic
    @Column(name = "museum_id")
    private Integer museumId;

}
