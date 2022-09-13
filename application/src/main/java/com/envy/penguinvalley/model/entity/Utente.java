package com.envy.penguinvalley.model.entity;

import com.envy.penguinvalley.regex.REGEX;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Utente")
public class Utente implements Serializable {

    @Id
    @Email(regexp = REGEX.UTENTE_EMAIL_REGEX,
           message = REGEX.UTENTE_EMAIL_MESSAGES)
    private String email;

    @Column(name = "dataPrimoInvio")
    private Date dataPrimoInvio;

    @Column(name = "dataLastInvio")
    private Date lastInvio;

    //TODO contare il numero di caricamenti effettuati da questa mail
    @Transient // field non presente nel database
    private int numeroCaricamenti;

    @JsonIgnore
    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private Set<Pinguino> pinguiniCaricati = new HashSet<Pinguino>();

    @PostLoad
    private void onLoad() {
        this.numeroCaricamenti = pinguiniCaricati.size();
    }

    @PrePersist
    private void prePersist(){
        dataPrimoInvio = new Date();
    }

    @PreUpdate
    private void preUpdate(){
        lastInvio = new Date();
    }



}
