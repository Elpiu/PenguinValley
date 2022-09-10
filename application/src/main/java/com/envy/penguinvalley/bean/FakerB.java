package com.envy.penguinvalley.bean;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class FakerB {

    private static Faker faker = new Faker();

    public Faker getFaker() {
        return faker;
    }

    @Bean
    @Scope("singleton")
    public FakerB fakerBean(){
        return new FakerB();
    }

}
