package com.envy.penguinvalley.model.repository;

import com.envy.penguinvalley.model.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, String> {

    @Query(
            value = "SELECT * FROM Utente WHERE email = ? ",
            nativeQuery = true
    )
    public Utente getUtenteByEmail(String email);

    Optional<Utente> findByEmail(String email);

}
