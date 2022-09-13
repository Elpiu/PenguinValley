package com.envy.penguinvalley.mapper;

import com.envy.penguinvalley.dto.InserimentoPinguinoDTO;
import com.envy.penguinvalley.model.entity.Pinguino;
import com.envy.penguinvalley.model.entity.Utente;
import com.envy.penguinvalley.util.Triple;

import java.util.ArrayList;

public class ConverterInserimentoPinguino {


    public static Triple<Utente, Pinguino, ArrayList<Integer>> convertToEntity(
            InserimentoPinguinoDTO dto
    ){
        Utente u = new Utente();
        u.setEmail(dto.getEmail());
        Pinguino p = new Pinguino();
        p.setNome(dto.getNome());
        p.setAltezza(dto.getAltezza());
        p.setPeso(dto.getPeso());
        p.setProvenienza(dto.getProvenienza());
        p.setLinkFoto(dto.getLinkFoto());
        return new Triple<>(u, p, dto.getCategoria());
    }

}
