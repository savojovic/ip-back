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
@Table(name = "virtualbank", schema = "ip", catalog = "")
public class VirtualbankEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_virtualbank")
    private Integer idVirtualbank;

    @OneToMany(mappedBy = "virtualbank")
    @JsonIgnore
    @ToString.Exclude
    private List<AccountEntity> accounts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VirtualbankEntity that = (VirtualbankEntity) o;
        return idVirtualbank != null && Objects.equals(idVirtualbank, that.idVirtualbank);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
