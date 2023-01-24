package com.myrestaurant.store.restaurantservice.mapper;

import com.myrestaurant.store.restaurantservice.dto.DriverDTO;
import com.myrestaurant.store.restaurantservice.model.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper extends GenericMapper<Driver, DriverDTO>{
}
