package org.etf.unibl.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "account", schema = "ip", catalog = "")
public class AccountEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_Id")
    private Integer userId;

    @Basic
    @Column(name = "amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "virtualbank_id_virtualbank", referencedColumnName = "Id_virtualbank", nullable = false)
    private VirtualbankEntity virtualbank;

    @ManyToOne
    @JoinColumn(name = "card_card_num", referencedColumnName = "card_num", nullable = false)
    private CardEntity card;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private List<TransactionEntity> transactions;

}
