package com.envy.penguinvalley.configuration;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Admin",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenAPI30Configuration {}
//TODO Swagger token da swagger mi dice unable to read JSON value
//Token sicuramente valido
//https://www.baeldung.com/openapi-jwt-authentication
