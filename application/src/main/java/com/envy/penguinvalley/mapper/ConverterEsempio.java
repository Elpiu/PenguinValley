package com.envy.penguinvalley.mapper;

import com.envy.penguinvalley.dto.EsempioDTO;
import com.envy.penguinvalley.model.entity.Esempio;

import java.util.function.Function;

public class ConverterEsempio extends Converter<Esempio, EsempioDTO>{


    public ConverterEsempio() {
        super(ConverterEsempio::convertToEntity,
                ConverterEsempio::convertToDto);
    }

    private static EsempioDTO convertToDto(Esempio esempio){
        EsempioDTO dto = new EsempioDTO();
        dto.setId(esempio.getId());
        dto.setTitolo(esempio.getTitolo());
        dto.setDescrizione(esempio.getDescrizione());
        return dto;
    }

    private static Esempio convertToEntity(EsempioDTO dto){
        Esempio esempio = new Esempio();
        esempio.setId(dto.getId());
        esempio.setTitolo(dto.getTitolo());
        esempio.setDescrizione(dto.getDescrizione());
        return esempio;
    }

}
