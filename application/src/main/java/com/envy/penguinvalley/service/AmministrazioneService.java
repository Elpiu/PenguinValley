package com.envy.penguinvalley.service;

import com.envy.penguinvalley.model.entity.Pinguino;

import java.util.ArrayList;

public interface AmministrazioneService {

    public ArrayList<Pinguino> visualizzaRichieste();

    /**
     * Decide se accettare o rifiutare la richiesta in base al valore che viene passato
     * @param id identificativo della richiesta
     * @param decision true per accettare una richiesta, false per rifiutarla e cancellarla
     */
    public void decideArequest(Long id ,boolean decision);
}
