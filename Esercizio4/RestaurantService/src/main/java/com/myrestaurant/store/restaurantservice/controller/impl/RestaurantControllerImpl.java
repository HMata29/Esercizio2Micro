package com.myrestaurant.store.restaurantservice.controller.impl;

import com.myrestaurant.store.restaurantservice.controller.RestaurantController;
import com.myrestaurant.store.restaurantservice.dto.RestaurantDTO;
import com.myrestaurant.store.restaurantservice.dto.RestaurantIdsDTO;
import com.myrestaurant.store.restaurantservice.mapper.RestaurantMapper;
import com.myrestaurant.store.restaurantservice.model.Restaurant;
import com.myrestaurant.store.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantControllerImpl implements RestaurantController {
    private final RestaurantService restaurantService;

    private final RestaurantMapper restaurantMapper;

    private final RabbitTemplate rabbitTemplate;
    @Value("${app.pizza-service-url}")
    private String pizzaServiceUrl;


    @Value("${app.rabbitmq.routingkey}")
    private String routingKey;

    @Override
    @PostMapping("/addPizzas")
    public List<Object> addPizzasToRestaurant(@RequestBody List<RestaurantIdsDTO> restaurantIdsDTOS) {
        RestTemplate restTemplate = new RestTemplate();
        List <Object> result = List.of(restTemplate.postForObject(pizzaServiceUrl, restaurantIdsDTOS, Object[].class));
        rabbitTemplate.convertAndSend("", routingKey, "Added no. " + result.size()+ " pizzas!");
        return result;
    }

    @Override
    @GetMapping("/pizzas/{restaurantId}")
    public List<Object> getPizzasByRestaurantId(@PathVariable("restaurantId")Long restaurantId) {
        RestTemplate restTemplate = new RestTemplate();
        List <Object> result = List.of(Objects.requireNonNull(restTemplate.getForObject(pizzaServiceUrl + "/" + restaurantId, Object[].class)));// url   metodo che chiama l'atro micro e cosa riceve(Object) da qui chiamo rabbit
        return result;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantDTO save(@RequestBody RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantMapper.asEntity(restaurantDTO);
        Restaurant saved = restaurantService.save(restaurant);
        RestaurantDTO dto = restaurantMapper.asDTO(saved);
        return dto;
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestaurantDTO findById(@PathVariable("id")Long id) {
        Restaurant restaurant = restaurantService.findById(id).orElse(null);
        return restaurantMapper.asDTO(restaurant);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Long id) {
        restaurantService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<RestaurantDTO> list() {
        List<Restaurant> restaurants = restaurantService.findAll();
        return restaurantMapper.asDTOList(restaurants);
    }

    @Override
    @PutMapping("/{id}")
    public RestaurantDTO update(@RequestBody RestaurantDTO restaurantDTO,@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantMapper.asEntity(restaurantDTO);
        return restaurantMapper.asDTO(restaurantService.update(restaurant,id));
    }
}
