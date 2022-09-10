package com.envy.penguinvalley.mapper;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Converter<E, D> implements Mapper<E, D> {

    private final Function<D, E> fromDto;
    private final Function<E, D> fromEntity;

    public Converter(final Function<D, E> fromDto, final Function<E, D> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }


    public final E convertFromDto(final D dto) {
        return fromDto.apply(dto);
    }

    public final D convertFromEntity(final E entity) {
        return fromEntity.apply(entity);
    }

    public final List<E> createFromDtos(final Collection<D> dtos) {
        return dtos.stream().map(this::convertFromDto).collect(Collectors.toList());
    }

    public final List<D> createFromEntities(final Collection<E> entities) {
        return entities.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }
}
