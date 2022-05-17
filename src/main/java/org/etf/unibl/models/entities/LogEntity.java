package org.etf.unibl.models.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "log", schema = "ip", catalog = "")
public class LogEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_log")
    private Integer idLog;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "action")
    private String action;
    @Basic
    @Column(name = "date")
    private Timestamp date;

}
