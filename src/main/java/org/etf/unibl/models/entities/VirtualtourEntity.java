package org.etf.unibl.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

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

    @OneToMany(mappedBy = "virtualtourEntity")
    @JsonIgnore
    private List<ContentEntity> contents;

    @ManyToOne
    @JoinColumn(name = "museum_id", referencedColumnName = "id", nullable = false)
    private MuseumEntity museum;

}
