package com.myrestaurant.store.restaurantservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class DriverDTO {
    private Long id;

    private String name;
}
