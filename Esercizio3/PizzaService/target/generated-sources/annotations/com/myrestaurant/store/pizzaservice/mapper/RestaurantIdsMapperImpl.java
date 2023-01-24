package com.myrestaurant.store.pizzaservice.mapper;

import com.myrestaurant.store.pizzaservice.dto.RestaurantIdsDTO;
import com.myrestaurant.store.pizzaservice.model.RestaurantsIds;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-24T17:02:36+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class RestaurantIdsMapperImpl implements RestaurantIdsMapper {

    @Override
    public RestaurantsIds asEntity(RestaurantIdsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RestaurantsIds.RestaurantsIdsBuilder restaurantsIds = RestaurantsIds.builder();

        restaurantsIds.restaurantId( dto.getRestaurantId() );
        restaurantsIds.pizzaId( dto.getPizzaId() );

        return restaurantsIds.build();
    }

    @Override
    public RestaurantIdsDTO asDTO(RestaurantsIds entity) {
        if ( entity == null ) {
            return null;
        }

        RestaurantIdsDTO.RestaurantIdsDTOBuilder restaurantIdsDTO = RestaurantIdsDTO.builder();

        restaurantIdsDTO.restaurantId( entity.getRestaurantId() );
        restaurantIdsDTO.pizzaId( entity.getPizzaId() );

        return restaurantIdsDTO.build();
    }

    @Override
    public List<RestaurantsIds> asEntityList(List<RestaurantIdsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<RestaurantsIds> list = new ArrayList<RestaurantsIds>( dtoList.size() );
        for ( RestaurantIdsDTO restaurantIdsDTO : dtoList ) {
            list.add( asEntity( restaurantIdsDTO ) );
        }

        return list;
    }

    @Override
    public List<RestaurantIdsDTO> asDTOList(List<RestaurantsIds> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RestaurantIdsDTO> list = new ArrayList<RestaurantIdsDTO>( entityList.size() );
        for ( RestaurantsIds restaurantsIds : entityList ) {
            list.add( asDTO( restaurantsIds ) );
        }

        return list;
    }
}
