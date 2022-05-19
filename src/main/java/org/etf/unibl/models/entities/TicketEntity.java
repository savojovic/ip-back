package org.etf.unibl.models.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ticket")
public class TicketEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ticket_number")
    private Integer ticketNumber;
    @Basic
    @Column(name = "museum_id")
    private String museumId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "account_user_Id", nullable = false)
    private TransactionEntity transactionEntity;

}
