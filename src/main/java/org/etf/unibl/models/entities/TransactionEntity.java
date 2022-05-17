package org.etf.unibl.models.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transaction", schema = "ip", catalog = "")
public class TransactionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_transaction")
    private Integer idTransaction;
    @Basic
    @Column(name = "account_user_Id")
    private Integer accountUserId;
    @Basic
    @Column(name = "amount")
    private Double amount;

}
