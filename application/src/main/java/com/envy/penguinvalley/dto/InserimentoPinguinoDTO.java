package com.envy.penguinvalley.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class InserimentoPinguinoDTO implements Serializable {

    private String nome;
    private int altezza;
    private int peso;
    private String provenienza;
    private String linkFoto;
    private String email;
    private ArrayList<Integer> categoria;
}
