package com.envy.penguinvalley.unitTesting.service;

import com.envy.penguinvalley.exception.NoPenguinPresent;
import com.envy.penguinvalley.model.entity.Pinguino;
import com.envy.penguinvalley.model.repository.PinguinoRepository;
import com.envy.penguinvalley.model.repository.UtenteRepository;
import com.envy.penguinvalley.service.GestioneServiziService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.text.html.Option;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class TestGestioneServiziService {

    @InjectMocks
    private GestioneServiziService service;

    @Mock
    private PinguinoRepository pRepository;

    @Mock
    private UtenteRepository uRepository;

    //////////// METODO IMMAGINE RANDOM ////////////
    @Test
    public void testImmagineRandomWhenDBEmptyThrowNoPenguinPresent(){
        Mockito.when(pRepository.getPinguinoRandom())
                .thenReturn(Optional.empty());
        Assertions.assertThrows(NoPenguinPresent.class,
                ()-> service.immagineRandom());
    }
    @SneakyThrows
    @Test
    public void testImmagineRandomWhenDBHavePenguin(){
        Pinguino p = new Pinguino();
        Mockito.when(pRepository.getPinguinoRandom())
                .thenReturn(Optional.of(p));
        Assertions.assertNotNull(service.immagineRandom());
    }
    ////////////////////////////////////////////////

    //////////// METODO INSERT PINGUINO ////////////
    @Test
    public void testInserimentoPinguino(){

    }

}
