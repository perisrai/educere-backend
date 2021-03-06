package com.educere.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Experties extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinTable(
            name = "tutor_experties",
            joinColumns = @JoinColumn(
                    name = "experties_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "tutor_id", referencedColumnName = "id"))
    private Tutor tutor;

    @Column
    private String name;

    @Column
    private String category;

    @Column
    private long experience;

    @Column(columnDefinition = "TEXT")
    private String description;
}
