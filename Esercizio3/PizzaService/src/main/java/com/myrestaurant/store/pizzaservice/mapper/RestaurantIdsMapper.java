package com.myrestaurant.store.pizzaservice.mapper;

import com.myrestaurant.store.pizzaservice.dto.RestaurantIdsDTO;
import com.myrestaurant.store.pizzaservice.model.RestaurantsIds;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantIdsMapper extends GenericMapper<RestaurantsIds, RestaurantIdsDTO>{
}
