package com.envy.penguinvalley.mapper;

import java.util.Collection;
import java.util.List;

interface Mapper <E, D> {

    public E convertFromDto(D dto);
    public D convertFromEntity(E entity);

    public List<E> createFromDtos(Collection<D> dto);
    public List<D> createFromEntities(Collection<E> entities);
}
