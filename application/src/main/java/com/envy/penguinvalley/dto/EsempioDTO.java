package com.envy.penguinvalley.dto;

import com.envy.penguinvalley.regex.REGEX;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class EsempioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @Pattern(regexp = REGEX.LENGHT_2_50,
            message = REGEX.LENGHT_2_50_MESSAGES)
    private String titolo;
    private String descrizione;

}
