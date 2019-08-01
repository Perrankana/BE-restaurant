package com.pickeat.restaurantapp.model.mappers

import com.pickeat.restaurantapp.entities.RestaurantDao
import com.pickeat.restaurantapp.entities.menu.MenuDao
import com.pickeat.restaurantapp.model.menu.Menu

fun Menu.toDao(restaurant: RestaurantDao): MenuDao =
        MenuDao(
                restaurant = restaurant,
                name = name,
                description = description
        )