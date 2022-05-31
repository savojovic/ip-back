package org.etf.unibl.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "virtualtour")
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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "content_id", referencedColumnName = "id", nullable = false)
    private ContentEntity content;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "museum_id", referencedColumnName = "id", nullable = false)
    private MuseumEntity museum;
}
