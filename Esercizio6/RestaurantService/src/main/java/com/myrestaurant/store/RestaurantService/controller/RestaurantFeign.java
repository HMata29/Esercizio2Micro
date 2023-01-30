package com.myrestaurant.store.RestaurantService.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("Restaurant")
public interface RestaurantFeign {
    @RequestMapping(method = RequestMethod.GET, value = "/pizzas/{restaurantId}")
    public List<Object> getPizzasByRestaurantId(@PathVariable("restaurantId") Long restaurantId);
}
