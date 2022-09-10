package com.envy.penguinvalley.model.entity;

import com.envy.penguinvalley.regex.REGEX;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "esempio")
public class Esempio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = REGEX.LENGHT_2_50,
            message = REGEX.LENGHT_2_50_MESSAGES)
    @Column(name = "titolo", nullable = false, unique = true)
    private String titolo;

    @Column(name = "descrizione")
    private String descrizione = "Non ancora Inserita";

    @CreationTimestamp
    @Column(name = "createdOn")
    private Date createdOn;

    @Column(name = "lastModifiedOn")
    private Date lastModifiedOn;

    @PrePersist
    protected void onPrePersist(){
        createdOn = new Date();
    }
    @PreUpdate
    protected void onPreUpdate(){
        lastModifiedOn  = new Date();
    }

}
