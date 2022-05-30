package org.etf.unibl.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "virtualtour")
public class VirtualtourEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tour")
    private Integer idTour;
    @Basic
    @Column(name = "start_date")
    private Date startDate;
    @Basic
    @Column(name = "duration")
    private String duration;

    @JsonIgnore
    @OneToMany(mappedBy = "virtualtourEntity")
    @ToString.Exclude
    private List<ContentEntity> contents;

    @ManyToOne
    @JoinColumn(name = "museum_id", referencedColumnName = "id", nullable = false)
    private MuseumEntity museum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VirtualtourEntity that = (VirtualtourEntity) o;
        return idTour != null && Objects.equals(idTour, that.idTour);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}