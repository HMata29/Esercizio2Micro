package com.myrestaurant.store.restaurantservice;

import com.myrestaurant.store.restaurantservice.dao.RestaurantRepository;
import com.myrestaurant.store.restaurantservice.model.Driver;
import com.myrestaurant.store.restaurantservice.model.Restaurant;
import com.myrestaurant.store.restaurantservice.service.DriverService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
class RestaurantServiceApplicationTests {
	@Autowired
	RestaurantRepository restaurantRepository;

	@Test
	void contextLoads() {
	}
	@Test
	void populateDB() {
		Driver driver1 = Driver.builder().name("Driver1").build();
		Driver driver2 = Driver.builder().name("Driver2").build();
		Driver driver3 = Driver.builder().name("Driver3").build();
		Driver driver4 = Driver.builder().name("Driver4").build();
		Driver driver5 = Driver.builder().name("Driver5").build();
		Driver driver6 = Driver.builder().name("Driver6").build();
		Restaurant vogliaDiPizza = Restaurant.builder()
				.name("Voglia di pizza").address("Via Roma")
				.city("Roma")
				.drivers(Set.of(driver1, driver2, driver3))
				.build();
		Restaurant pizzaAGoGo = Restaurant.builder()
				.name("Pizza a GoGo")
				.address("Via Milano")
				.city("Milano")
				.drivers(Set.of(driver4, driver5, driver6)).build();
		restaurantRepository.saveAll(List.of(vogliaDiPizza, pizzaAGoGo));

	}

}
