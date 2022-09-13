package com.envy.penguinvalley.web.controller;

import com.envy.penguinvalley.dto.InserimentoPinguinoDTO;
import com.envy.penguinvalley.exception.NoPenguinPresent;
import com.envy.penguinvalley.mapper.ConverterInserimentoPinguino;
import com.envy.penguinvalley.model.entity.Pinguino;
import com.envy.penguinvalley.model.entity.Utente;
import com.envy.penguinvalley.service.GestioneServiziService;
import com.envy.penguinvalley.util.Triple;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/serviceV1")
public class GestioneServiziController {

    @Autowired
    private GestioneServiziService serviziS;

    @Operation(summary = "Fetch random Image of penguin")
    @GetMapping("/fetchRandom")
    public ResponseEntity<Pinguino> fetchRandom()
        throws NoPenguinPresent{
        return ResponseEntity.ok().body(serviziS.immagineRandom());
    }

    @Operation(summary = "Inserisce un nuovo dato")
    @PostMapping("/insertPinguino")
    public boolean insertPinguino(
            @Valid @RequestBody InserimentoPinguinoDTO pDTO){
        Triple<Utente, Pinguino, ArrayList<Integer>> triple =
                ConverterInserimentoPinguino.convertToEntity(pDTO);
        serviziS.insertPinguino(triple.getSecond(),
                                triple.getFirst(),
                                triple.getThird()
        );
        return true;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Pinguino> getPinguinoById(
            @PathVariable (value = "id") Long id) throws NoPenguinPresent{
        Pinguino p = serviziS.immagineSpecifica(id);
        return ResponseEntity.ok().body(p);
    }

    @GetMapping("/getListaImmagini")
    public ResponseEntity<List<String>> getListaImmagini()
            throws NoPenguinPresent {
        return ResponseEntity.ok().body(serviziS.listaImamgini());
    }
}
