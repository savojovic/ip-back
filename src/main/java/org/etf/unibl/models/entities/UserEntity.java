package org.etf.unibl.models.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user", schema = "ip", catalog = "")
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
    private Boolean isAdmin;
    @Basic
    @Column(name = "token")
    private String token;
    @Basic
    @Column(name = "active_time")
    private String activeTime;

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

}
