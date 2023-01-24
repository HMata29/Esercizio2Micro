package com.myrestaurant.store.pizzaservice.service.impl;

import com.myrestaurant.store.pizzaservice.dao.PizzaRepository;
import com.myrestaurant.store.pizzaservice.model.Pizza;
import com.myrestaurant.store.pizzaservice.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository repository;

    @Override
    public Pizza save(Pizza entity) {
        return repository.save(entity);
    }

    @Override
    public List<Pizza> save(List<Pizza> entities) {
        return (List <Pizza> )repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Pizza> findById(Long id) {
        return  repository.findById(id);
    }

    @Override
    public List<Pizza> findAll() {
        return repository.findAll();
    }

    @Override
    public Pizza update(Pizza entity, Long id) {
        Optional <Pizza> optional = findById(id);
        if(optional.isPresent()){
            return save(entity);
        }
        return null;
    }
}
