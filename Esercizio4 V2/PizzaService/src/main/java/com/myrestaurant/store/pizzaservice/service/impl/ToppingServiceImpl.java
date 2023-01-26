package com.myrestaurant.store.pizzaservice.service.impl;

import com.myrestaurant.store.pizzaservice.dao.ToppingRepository;
import com.myrestaurant.store.pizzaservice.model.Topping;
import com.myrestaurant.store.pizzaservice.service.ToppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ToppingServiceImpl implements ToppingService {
    private final ToppingRepository repository;

    @Override
    public Topping save(Topping entity) {
        return repository.save(entity);
    }

    @Override
    public List<Topping> save(List<Topping> entities) {
        return (List <Topping> )repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Topping> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Topping> findAll() {
        return (List<Topping>) repository.findAll();
    }

    @Override
    public Topping update(Topping entity, Long id) {
        Optional <Topping> optional = findById(id);
        if(optional.isPresent()){
            return save(entity);
        }
        return null;
    }
}
