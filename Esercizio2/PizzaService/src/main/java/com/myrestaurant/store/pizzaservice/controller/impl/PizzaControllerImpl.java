package com.myrestaurant.store.pizzaservice.controller.impl;

import com.myrestaurant.store.pizzaservice.controller.PizzaController;
import com.myrestaurant.store.pizzaservice.dto.PizzaDTO;
import com.myrestaurant.store.pizzaservice.mapper.PizzaMapper;
import com.myrestaurant.store.pizzaservice.model.Pizza;
import com.myrestaurant.store.pizzaservice.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
@RequiredArgsConstructor
public class PizzaControllerImpl implements PizzaController {
    private final PizzaService pizzaService;

    private final PizzaMapper pizzaMapper;



    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PizzaDTO save(@RequestBody PizzaDTO pizzaDTO) {
        Pizza pizza = pizzaMapper.asEntity(pizzaDTO);
        Pizza saved = pizzaService.save(pizza);
        PizzaDTO dto = pizzaMapper.asDTO(saved);
        return dto;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public PizzaDTO findById(@PathVariable("id") Long id) {
        Pizza pizza = pizzaService.findById(id).orElse(null);
        return pizzaMapper.asDTO(pizza);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        pizzaService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<PizzaDTO> list() {
        List<Pizza> pizzas = pizzaService.findAll();
        return pizzaMapper.asDTOList(pizzas);
    }

    @Override
    @PutMapping("/{id}")
    public PizzaDTO update(@RequestBody PizzaDTO pizza,@PathVariable("id") Long id) {
        Pizza pizza1 = pizzaMapper.asEntity(pizza);
        return pizzaMapper.asDTO(pizzaService.update(pizza1,id));
    }
}
