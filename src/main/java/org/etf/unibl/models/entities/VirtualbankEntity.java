package org.etf.unibl.models.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "virtualbank", schema = "ip", catalog = "")
public class VirtualbankEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_virtualbank")
    private Integer idVirtualbank;

}
