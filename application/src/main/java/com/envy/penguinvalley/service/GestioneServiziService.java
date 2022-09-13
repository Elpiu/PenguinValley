package com.envy.penguinvalley.service;


import com.envy.penguinvalley.exception.NoPenguinPresent;
import com.envy.penguinvalley.model.entity.Pinguino;
import com.envy.penguinvalley.model.entity.Utente;
import com.envy.penguinvalley.model.repository.PinguinoRepository;
import com.envy.penguinvalley.model.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Gestione Servizi,
 *  Immagine Random
 *  Inserisci Immagine
 *  Immagine Specifica
 *  Lista Immagini
 */
@Service
public class GestioneServiziService implements GestioneServizi{

    /*@See listaImamgini*/
    private static final int MAX_NUMBER_LINK = 10;

    @Autowired
    PinguinoRepository pRepository;
    @Autowired
    UtenteRepository uRepository;

    /**
     * Metodo che sceglie un pinguino random e lo restituisce
     * @return pinguino scelto a caso dal database
     * @throws NoPenguinPresent se nel database non sono presenti pinguini
     */
    public Pinguino immagineRandom()
        throws NoPenguinPresent{
        Optional<Pinguino> pinguinoWrapper = pRepository.getPinguinoRandom();
        if(!pinguinoWrapper.isPresent()) throw new NoPenguinPresent();

        return pinguinoWrapper.get();
    }

    /**
     * Inserisci un imamgine, viene effettuato da un user
     * @param p I paramentri dfel pinguino da inserire
     * @param u I parametri dell'utente da inserire
     */
    public void insertPinguino(Pinguino p, Utente u, ArrayList<Integer> categorie){
        if(!checkValidPinguino(p)) throw new IllegalArgumentException("Invalid Pinguino");
        if(!checkValidUtente(u)) throw new IllegalArgumentException("Invalid Utente");

        //Controllare se è il primo inserimento con quell'email
        Optional<Utente> ut = uRepository.findByEmail(u.getEmail());
        u = ut.isPresent() ? ut.get() : uRepository.save(u);

        p.setUtente(u);
        u.getPinguiniCaricati().add(p);
        uRepository.save(u);

        //TODO aggiungere le categorie
    }

    /**
     * Get Pinguino dall'id
     * @param id Id del pinguino
     * @return Pinguino dall'id'
     * @throws NoPenguinPresent
     */
    public Pinguino immagineSpecifica(Long id)
            throws NoPenguinPresent{
        Optional<Pinguino> pinguinoWrapper = pRepository.findById(id);
        if(!pinguinoWrapper.isPresent()) throw new NoPenguinPresent();

        return pinguinoWrapper.get();
    }

    /**
     * Metodo restituente una lista di link
     * @return Returns a list of link presenti immagini di pinguini
     */
    public List<String> listaImamgini()
            throws NoPenguinPresent {
        ArrayList<String> list = (ArrayList<String>) pRepository.getPinguinoFotoLinks(GestioneServiziService.MAX_NUMBER_LINK);
        if(list.size() == 0) throw new NoPenguinPresent();
        return list;
    }

    /**
     * Controlla i parametri se sono validi
     * @param p Pinguino da controlalre
     * @return true valido, false non valido
     */
    private boolean checkValidPinguino(Pinguino p){
        //TODO
        return true;
    }

    /**
     * Controlla i parametri se sono validi
     * @param u Utente da controlalre
     * @return true valido, false non valido
     */
    private boolean checkValidUtente(Utente u){
        //TODO
        return true;
    }

}
