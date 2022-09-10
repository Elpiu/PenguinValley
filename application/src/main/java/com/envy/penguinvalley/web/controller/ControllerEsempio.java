package com.envy.penguinvalley.web.controller;


import com.envy.penguinvalley.bean.FakerB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/esempio")
public class ControllerEsempio {

    @Autowired
    private FakerB fakerB;

    @GetMapping("/randomFullNames")
    public List<String> getNames() {
        return new ArrayList<String>(){{
            for (int i = 0; i < 10; i++)
                add(fakerB.getFaker().name().fullName());
        }};
    }

    @GetMapping("/random/{id}")
    public List<String> getNames(@PathVariable long id){
        return new ArrayList<String>(){{
            for (int i = 0; i < id; i++)
                add(fakerB.getFaker().name().fullName());
        }};
    }

}
