package com.envy.penguinvalley.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
//Swagger
//@SecurityRequirement(name = "Admin")
public class AdminController {


    @Operation(summary = "Username dell'utente")
    @GetMapping("/getUsername")
    public String getUsername() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return securityContext.getAuthentication().getName();
    }
}
