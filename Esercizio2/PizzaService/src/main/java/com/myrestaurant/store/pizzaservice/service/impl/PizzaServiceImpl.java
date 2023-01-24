package com.myrestaurant.store.pizzaservice.service.impl;

import com.myrestaurant.store.pizzaservice.dao.PizzaRepository;
import com.myrestaurant.store.pizzaservice.dao.RestaurantIdsRepository;
import com.myrestaurant.store.pizzaservice.model.Pizza;
import com.myrestaurant.store.pizzaservice.model.RestaurantsIds;
import com.myrestaurant.store.pizzaservice.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;

    private final RestaurantIdsRepository restaurantIdsRepository;

    @Override
    public Pizza save(Pizza entity) {
        return pizzaRepository.save(entity);
    }

    @Override
    public List<Pizza> save(List<Pizza> entities) {
        return (List <Pizza> ) pizzaRepository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        pizzaRepository.deleteById(id);
    }

    @Override
    public Optional<Pizza> findById(Long id) {
        return  pizzaRepository.findById(id);
    }

    @Override
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza update(Pizza entity, Long id) {
        Optional <Pizza> optional = findById(id);
        if(optional.isPresent()){
            return save(entity);
        }
        return null;
    }

    @Override
    public List<Pizza> findByRestaurantId(Long restaurantId) {
        List <RestaurantsIds> restaurantsIds = restaurantIdsRepository.findByRestaurantId(restaurantId);
        List <Pizza> pizzas = new ArrayList<>(restaurantsIds.size());
        for (RestaurantsIds el : restaurantsIds){
            pizzas.add(pizzaRepository.findById(el.getPizzaId()).get());
        }
        return pizzas;
    }
}
