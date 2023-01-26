package com.myrestaurant.store.restaurantservice.controller;


import com.myrestaurant.store.restaurantservice.dto.RestaurantDTO;
import com.myrestaurant.store.restaurantservice.dto.RestaurantIdsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(tags = "restaurant API")
public interface RestaurantController {

    @ApiOperation("Add pizzas to the restaurant")
    public List <Object> addPizzasToRestaurant(@RequestBody List <RestaurantIdsDTO> restaurantIdsDTOS);

    @ApiOperation("find all pizzas by restaurant id ")
    public List <Object> getPizzasByRestaurantId(@PathVariable("id") Long restaurantId);

    @ApiOperation("Add new Restaurant ")
    public RestaurantDTO save(@RequestBody RestaurantDTO restaurantDTO);

    @ApiOperation("Find Restaurant By id")
    public RestaurantDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete By id")
    public void delete (@PathVariable("id") Long id);

    @ApiOperation("Find all restaurants")
    public List<RestaurantDTO> list();

    @ApiOperation("update Restaurants")
    public RestaurantDTO update(@RequestBody RestaurantDTO restaurantDTO,@RequestParam("id") Long id);
}
