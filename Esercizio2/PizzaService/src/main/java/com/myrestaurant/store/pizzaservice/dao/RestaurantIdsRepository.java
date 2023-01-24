package com.myrestaurant.store.pizzaservice.dao;

import com.myrestaurant.store.pizzaservice.model.RestaurantsIds;
import com.myrestaurant.store.pizzaservice.model.RestaurantsIdsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantIdsRepository extends JpaRepository<RestaurantsIds, RestaurantsIdsPK> {
    List<RestaurantsIds> findByRestaurantId(Long restaurantId);
}
