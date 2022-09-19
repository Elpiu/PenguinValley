package com.envy.penguinvalley.web.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
//Swagger
//@SecurityRequirement(name = "Admin")
public class AdminController {

    //https://www.youtube.com/watch?v=X80nJ5T7YpE

    @GetMapping("/getUsername")
    public String getUsername() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return securityContext.getAuthentication().getName();
    }


}
