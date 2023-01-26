package com.myrestaurant.store.pizzaservice.service;

import java.util.List;
import java.util.Optional;

public interface GenericsService <E,M> {

    E save(E entity);

    List<E> save(List <E> entities);

    void deleteById(M id);

    Optional <E> findById(M id);

    List <E> findAll();
    E update(E entity, M id);
}
