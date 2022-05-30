package org.etf.unibl.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    @JsonIgnore
    @OneToMany(mappedBy = "museum")
    @ToString.Exclude
    private List<MuseumticketEntity> museumtickets;

    @JsonIgnore
    @OneToMany(mappedBy = "museum")
    @ToString.Exclude
    private List<VirtualtourEntity> virtualtours;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MuseumEntity that = (MuseumEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
