package com.envy.penguinvalley.model.repository;

import com.envy.penguinvalley.model.entity.Pinguino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PinguinoRepository extends JpaRepository<Pinguino, Long> {

    @Query(
            value = "SELECT * FROM Pinguino WHERE is_disponibile = true ORDER BY RAND() LIMIT 1",
            nativeQuery = true
    )
    public Optional<Pinguino> getPinguinoRandom();

    @Query(
            value = "SELECT link_foto FROM Pinguino WHERE is_disponibile = true ORDER BY RAND() LIMIT ?",
            nativeQuery = true
    )
    public List<String> getPinguinoFotoLinks(int number);

    @Query(
            value = "SELECT * FROM Pinguino WHERE is_disponibile = false",
            nativeQuery = true
    )
    public List<Pinguino> getPinguinoNotDisponibile();
}
