package com.myrestaurant.store.restaurantservice.controller;


import com.myrestaurant.store.restaurantservice.dto.DriverDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(tags = "driver API")
public interface DriverControleller {
    @ApiOperation("Add new Driver ")
    public DriverDTO save(@RequestBody DriverDTO driverDTO);

    @ApiOperation("Find Driver By id")
    public DriverDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete By id")
    public void delete (@PathVariable("id") Long id);

    @ApiOperation("Find all drivers")
    public List<DriverDTO> list();

    @ApiOperation("update driver")
    public DriverDTO update(@RequestBody DriverDTO driverDTO,@RequestParam("id") Long id);
}
