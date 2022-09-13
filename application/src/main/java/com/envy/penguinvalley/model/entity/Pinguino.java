package com.envy.penguinvalley.model.entity;

import com.envy.penguinvalley.regex.REGEX;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Pinguino")
public class Pinguino implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Pattern(regexp = REGEX.PINGUINO_NOME_REGEX,
             message = REGEX.PINGUINO_NOME_MESSAGES)
    @Length(message = "Nome Pinguino troppo corto (o lungo)", min = 2, max = 50)
    @Column(name = "nome", nullable = false, unique = false)
    private String nome;

    @PositiveOrZero
    @Column(name = "altezza", nullable = false)
    private int altezza;

    @PositiveOrZero
    @Column(name = "peso", nullable = false)
    private int peso;

    @Length(message = "Nome provenienza troppo corto (o lungo)", min = 2, max = 50)
    @Column(name = "provenienza", nullable = true)
    private String provenienza ="Antartide";

    @Column(name = "isDisponibile", nullable = false)
    private boolean isDisponible = false;

    @Column(name = "linkFoto", nullable = false, length = 500)
    private String linkFoto;

    @JsonIgnoreProperties
    @ManyToMany
    @JoinTable(name = "setCategoria",
               joinColumns = @JoinColumn(name = "pinguino_id"),
               inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private Set<Categoria> setCategoria ;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "utente_email", nullable = false)
    private Utente utente;

}
