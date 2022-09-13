package com.envy.penguinvalley.service;

import com.envy.penguinvalley.exception.NoPenguinPresent;
import com.envy.penguinvalley.model.entity.Pinguino;
import com.envy.penguinvalley.model.entity.Utente;

import java.util.ArrayList;
import java.util.List;

public interface GestioneServizi {

    public Pinguino immagineRandom() throws NoPenguinPresent;
    public void insertPinguino(Pinguino p, Utente u, ArrayList<Integer> c);
    public Pinguino immagineSpecifica(Long id) throws NoPenguinPresent;
    public List<String> listaImamgini() throws NoPenguinPresent;

}
