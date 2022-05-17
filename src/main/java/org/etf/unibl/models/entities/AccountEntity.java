package org.etf.unibl.models.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account", schema = "ip", catalog = "")
public class AccountEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_Id")
    private Integer userId;
    @Basic
    @Column(name = "virtualbank_id_virtualbank")
    private Integer virtualbankIdVirtualbank;
    @Basic
    @Column(name = "card_card_num")
    private Integer cardCardNum;
    @Basic
    @Column(name = "amount")
    private Double amount;

}
