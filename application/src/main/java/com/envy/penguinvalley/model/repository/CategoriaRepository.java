package com.envy.penguinvalley.model.repository;

import com.envy.penguinvalley.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
