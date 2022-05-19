package org.etf.unibl.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "card", schema = "ip", catalog = "")
public class CardEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "card_num")
    private Integer cardNum;

    @OneToMany(mappedBy = "card")
    @JsonIgnore
    private List<AccountEntity> accounts;
}
