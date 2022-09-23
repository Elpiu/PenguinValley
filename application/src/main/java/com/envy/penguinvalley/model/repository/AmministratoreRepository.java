package com.envy.penguinvalley.model.repository;

import com.envy.penguinvalley.model.entity.Amministratore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AmministratoreRepository
        extends JpaRepository<Amministratore, Long> {

    public Optional<Amministratore> findByUsername(String username);


}
