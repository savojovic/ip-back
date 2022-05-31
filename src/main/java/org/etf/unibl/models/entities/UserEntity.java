package org.etf.unibl.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "pass_hash")
    private String passHash;
    @Basic
    @Column(name = "is_admin")
    private Byte isAdmin;
    @Basic
    @Column(name = "token")
    private String token;
    @Basic
    @Column(name = "active_time")
    private String activeTime;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<LogEntity> logs;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<MuseumticketEntity> museumtickets;

}
