package com.envy.penguinvalley.model.repository;

import com.envy.penguinvalley.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, Long> {

    public Optional<User> findByUsername(String username);

}