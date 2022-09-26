package com.envy.penguinvalley.dto.auth;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class AuthenticationResponseDTO implements Serializable {

    private final String jwt;

    public AuthenticationResponseDTO(String jwt) {
        this.jwt = jwt;
    }
}
