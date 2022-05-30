package org.etf.unibl.models.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
    private MuseumEntity museum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MuseumticketEntity that = (MuseumticketEntity) o;
        return tickedNumber != null && Objects.equals(tickedNumber, that.tickedNumber);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
