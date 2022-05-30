package org.etf.unibl.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "content", schema = "ip", catalog = "")
public class ContentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "pic1")
    private String pic1;
    @Basic
    @Column(name = "pic2")
    private String pic2;
    @Basic
    @Column(name = "pic3")
    private String pic3;
    @Basic
    @Column(name = "pic4")
    private String pic4;
    @Basic
    @Column(name = "pic5")
    private String pic5;
    @Basic
    @Column(name = "Vid")
    private String vid;

    @OneToMany(mappedBy = "content")
    @JsonIgnore
    private List<VirtualtourEntity> tours;


}
