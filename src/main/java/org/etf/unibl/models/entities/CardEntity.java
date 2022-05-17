package org.etf.unibl.models.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "card", schema = "ip", catalog = "")
public class CardEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "card_num")
    private Integer cardNum;

}
