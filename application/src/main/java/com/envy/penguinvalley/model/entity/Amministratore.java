package com.envy.penguinvalley.model.entity;

import com.envy.penguinvalley.regex.REGEX;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Amministratore")
public class Amministratore implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Pattern(regexp = REGEX.ADMIN_USERNAME_REGEX,
             message = REGEX.ADMIN_USERNAME_MESSAGES)
    @Column(name = "username", nullable = false)
    private String username;

    @Pattern(regexp = REGEX.ADMIN_PASSWORD_REGEX,
             message = REGEX.ADMIN_PASSWORD_MESSAGES)
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "lastLogin", nullable = true)
    private Date lastLogin;
}
