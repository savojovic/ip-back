package org.etf.unibl.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    @Basic
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<LogEntity> logs;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<MuseumticketEntity> museumtickets;

    @Transient
    private final String ACTIVE_TIME = String.valueOf(0);
    @Transient
    private final Byte IS_NOT_ADMIN = 0;

    public UserEntity(String name, String surname, String username, String password, String email) {
        this.name=name;
        this.surname=surname;
        this.username = username;
        this.passHash = encryptPassword(password);
        this.email = email;
        this.activeTime = ACTIVE_TIME;
        this.isAdmin = IS_NOT_ADMIN;
    }
    public String encryptPassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
    public UserEntity() {
    }
}
