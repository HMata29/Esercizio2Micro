package com.myrestaurant.store.restaurantservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class DriverDTO {
    private Long id;

    private String name;
}
