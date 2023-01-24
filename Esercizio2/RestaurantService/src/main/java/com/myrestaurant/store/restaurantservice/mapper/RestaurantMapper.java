package com.myrestaurant.store.restaurantservice.mapper;

import com.myrestaurant.store.restaurantservice.dto.RestaurantDTO;
import com.myrestaurant.store.restaurantservice.model.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper extends GenericMapper<Restaurant, RestaurantDTO> {
}
