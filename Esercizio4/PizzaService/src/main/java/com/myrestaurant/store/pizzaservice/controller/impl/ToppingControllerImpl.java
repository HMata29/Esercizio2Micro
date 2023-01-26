package com.myrestaurant.store.pizzaservice.controller.impl;

import com.myrestaurant.store.pizzaservice.controller.ToppingController;
import com.myrestaurant.store.pizzaservice.dto.ToppingDTO;
import com.myrestaurant.store.pizzaservice.mapper.ToppingMapper;
import com.myrestaurant.store.pizzaservice.model.Topping;
import com.myrestaurant.store.pizzaservice.service.ToppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toppings")
@RequiredArgsConstructor
public class ToppingControllerImpl implements ToppingController {
    private final ToppingService toppingService;

    private final ToppingMapper toppingMapper;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ToppingDTO save(@RequestBody ToppingDTO toppingDTO) {
        Topping topping = toppingMapper.asEntity(toppingDTO);
        Topping saved = toppingService.save(topping);
        ToppingDTO dto = toppingMapper.asDTO(saved);
        return dto;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ToppingDTO findById( @PathVariable("id") Long id) {
        Topping topping = toppingService.findById(id).orElse(null);
        return toppingMapper.asDTO(topping);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        toppingService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<ToppingDTO> list() {
        List<Topping> toppings = toppingService.findAll();
        return toppingMapper.asDTOList(toppings);
    }

    @Override
    @PutMapping("/{id}")
    public ToppingDTO update(@RequestBody ToppingDTO toppingDTO, @PathVariable("id") Long id) {
        Topping topping = toppingMapper.asEntity(toppingDTO);
        return toppingMapper.asDTO(toppingService.update(topping,id));
    }
}
