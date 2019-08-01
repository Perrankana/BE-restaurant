package com.pickeat.restaurantapp.model.mappers

import com.pickeat.restaurantapp.entities.RestaurantDao
import com.pickeat.restaurantapp.model.Restaurant

fun Restaurant.toDao(): RestaurantDao =
        RestaurantDao(
                name = name,
                address = address,
                city = city,
                postcode = postcode,
                logo = logo,
                image = image,
                latitude = latitude,
                longitude = longitude
        )