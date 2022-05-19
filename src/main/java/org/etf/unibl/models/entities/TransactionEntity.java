package org.etf.unibl.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_transaction")
    private Integer idTransaction;
    @Basic
    @Column(name = "amount")
    private Double amount;

    @OneToMany(mappedBy = "transactionEntity")
    @JsonIgnore
    private List<TicketEntity> tickets;

    @ManyToOne
    @JoinColumn(name = "account_user_Id", referencedColumnName = "user_Id", nullable = false)
    private AccountEntity account;
}
