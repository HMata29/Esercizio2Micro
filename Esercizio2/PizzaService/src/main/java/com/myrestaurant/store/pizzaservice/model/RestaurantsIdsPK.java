package com.myrestaurant.store.pizzaservice.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantsIdsPK implements Serializable {

    private Long restaurantId;

    private Long pizzaId;
}
