package com.envy.penguinvalley.web.controller;


import com.envy.penguinvalley.bean.FakerB;
import com.envy.penguinvalley.model.entity.Categoria;
import com.envy.penguinvalley.model.entity.Pinguino;
import com.envy.penguinvalley.model.entity.Utente;
import com.envy.penguinvalley.model.repository.CategoriaRepository;
import com.envy.penguinvalley.model.repository.UtenteRepository;
import com.envy.penguinvalley.service.GestioneServiziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/fillDatabase")
public class ControllerFillDatabase {

    @Autowired
    private FakerB fakerB;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private GestioneServiziService gestioneServiziService;

    @GetMapping("/categoria")
    public List<Categoria> fillCategoria() {
        ArrayList<Categoria> list = new ArrayList<Categoria>();
        for (int i = 0; i < 50; i++) {
            Categoria c = new Categoria();
            c.setNomeCategoria(fakerB.getFaker().company().name());
            c.setSpecialSkill(fakerB.getFaker().name().title());
            list.add(c);
        }
        list = (ArrayList<Categoria>) categoriaRepository.saveAll(list);
        return list;
    }

    @GetMapping("/utenti")
    public List<Utente> fillUtenti(){
        ArrayList<Utente> list = new ArrayList<Utente>();
        for (int i = 0; i < 50; i++) {
            Utente u = new Utente();
            u.setEmail(fakerB.getFaker().internet().emailAddress());
            list.add(u);
        }
        list = (ArrayList<Utente>) utenteRepository.saveAll(list);
        return list;
    }

    @GetMapping("/addPenguins")
    public String addPenguins(){
        Random r = new Random();
        ArrayList<Utente> listUtenti = new ArrayList<Utente>();
        listUtenti = (ArrayList<Utente>) utenteRepository.findAll();
        for (int i = 0; i < 50; i++) {
            try {
                Pinguino p = new Pinguino();
                p.setProvenienza(fakerB.getFaker().country().name());
                p.setNome(fakerB.getFaker().name().fullName());
                p.setAltezza(fakerB.getFaker().number().numberBetween(1, 200));
                p.setPeso(fakerB.getFaker().number().numberBetween(20, 400));
                p.setDisponible(r.nextBoolean());
                p.setLinkFoto(fakerB.getFaker().internet().url());

                Utente u = listUtenti.get(r.nextInt(listUtenti.size()));
                //TODO add caegories
                gestioneServiziService.insertPinguino(p, u, new ArrayList<Integer>());
            }catch (Exception e){

            }
        }
        return "done";
    }

}
