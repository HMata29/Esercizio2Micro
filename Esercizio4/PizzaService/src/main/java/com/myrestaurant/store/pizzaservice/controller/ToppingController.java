package com.myrestaurant.store.pizzaservice.controller;


import com.myrestaurant.store.pizzaservice.dto.ToppingDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(tags = "Topping API")
public interface ToppingController {

    @ApiOperation("Add new Topping ")
    public ToppingDTO save(@RequestBody ToppingDTO toppingDTO);

    @ApiOperation("Find Topping By id")
    public ToppingDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete By id")
    public void delete (@PathVariable("id") Long id);

    @ApiOperation("Find all Toppings")
    public List<ToppingDTO> list();

    @ApiOperation("update Topping")
    public ToppingDTO update(@RequestBody ToppingDTO toppingDTO,@RequestParam("id") Long id);
}
