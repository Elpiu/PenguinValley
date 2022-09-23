package com.envy.penguinvalley.service;

import com.envy.penguinvalley.model.entity.Pinguino;
import com.envy.penguinvalley.model.repository.PinguinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GestioneAmministrazioneService implements AmministrazioneService{

    @Autowired
    private PinguinoRepository pinguinoRepository;

    @Override
    public ArrayList<Pinguino> visualizzaRichieste() {
        ArrayList<Pinguino> pinguiniList =
                (ArrayList<Pinguino>) pinguinoRepository.getPinguinoNotDisponibile();
        return pinguiniList;
    }

    @Override
    public void decideArequest(Long id, boolean decision) {
        Pinguino p = pinguinoRepository.getReferenceById(id);
        if(p==null) return;

        if(decision){
            p.setDisponible(true);
            pinguinoRepository.save(p);
        }
        else
            pinguinoRepository.deleteById(p.getId());
    }
}
