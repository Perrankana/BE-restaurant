package com.pickeat.restaurantapp.entities.mappers

import com.pickeat.restaurantapp.entities.RestaurantDao
import com.pickeat.restaurantapp.model.Restaurant

fun List<RestaurantDao>.toDomain(): List<Restaurant> =
        map { it.toDomain() }

fun RestaurantDao.toDomain(): Restaurant =
        Restaurant(id, name, address, city, postcode, logo, image, latitude, longitude)
