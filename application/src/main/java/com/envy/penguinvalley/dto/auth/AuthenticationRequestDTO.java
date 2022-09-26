package com.envy.penguinvalley.dto.auth;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthenticationRequestDTO implements Serializable {

    private String username;
    private String password;

    public AuthenticationRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public AuthenticationRequestDTO() {}
}
