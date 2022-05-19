package org.etf.unibl.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "virtualbank", schema = "ip", catalog = "")
public class VirtualbankEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_virtualbank")
    private Integer idVirtualbank;

    @OneToMany(mappedBy = "virtualbank")
    @JsonIgnore
    private List<AccountEntity> accounts;

}
