package com.myrestaurant.store.RestaurantService.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
@Profile("dev")
public class DataSourceConfigDev {

    public DataSourceConfigDev() {

        System.out.println("I'm into DataSourceConfigDev class");
    }

}
