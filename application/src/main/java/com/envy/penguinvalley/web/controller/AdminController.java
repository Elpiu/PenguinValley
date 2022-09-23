package com.envy.penguinvalley.web.controller;

import com.envy.penguinvalley.model.entity.Pinguino;
import com.envy.penguinvalley.service.GestioneAmministrazioneService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
//Swagger
//@SecurityRequirement(name = "Admin")
public class AdminController {

    @Autowired
    private GestioneAmministrazioneService gestAmminiService;

    @GetMapping("/getUsername")
    public String getUsername() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return securityContext.getAuthentication().getName();
    }


    @Operation(summary = "Visualizza le richieste in attesa di accettazione" +
            " inviate dagli utenti")
    @GetMapping("/visualizzaRichieste")
    public ResponseEntity<ArrayList<Pinguino>> getRichieste(){
        return ResponseEntity.ok().body(gestAmminiService.visualizzaRichieste());
    }

    @Operation(summary = "Decide se accettare o rifiutare una richiesta")
    @GetMapping("/decidiRichiesta")
    public String decidiRichiesta(@RequestParam Long id,
                                  @RequestParam boolean decisione) {
        gestAmminiService.decideArequest(id, decisione);
        return "done";
    }
}
