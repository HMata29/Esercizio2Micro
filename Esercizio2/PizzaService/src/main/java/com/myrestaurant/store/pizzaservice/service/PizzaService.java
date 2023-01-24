package com.myrestaurant.store.pizzaservice.service;



import com.myrestaurant.store.pizzaservice.model.Pizza;

import java.util.List;

public interface PizzaService extends GenericsService <Pizza, Long>{
    List <Pizza> findByRestaurantId(Long restaurantId);
}
