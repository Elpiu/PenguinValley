package com.envy.penguinvalley.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Length(message = "Nome categoria troppo corto (o lungo)", min = 2, max = 50)
    @Column(name = "nomeCategoria",unique = true, nullable = false)
    private String nomeCategoria;

    @Length(message = "Nome specialSkill troppo corto (o lungo)", min = 2, max = 50)
    @Column(name = "specialSkill", nullable = false)
    private String specialSkill;

    @JsonIgnoreProperties
    @ManyToMany(mappedBy = "setCategoria")
    private List<Pinguino> listaPinguino;
}
