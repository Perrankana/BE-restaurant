package com.pickeat.restaurantapp.repositories

import com.pickeat.restaurantapp.entities.Restaurant
import org.springframework.data.repository.CrudRepository

interface RestaurantRepository: CrudRepository<Restaurant, Long>
