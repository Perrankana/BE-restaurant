package com.pickeat.restaurantapp.repositories

import com.pickeat.restaurantapp.entities.RestaurantDao
import org.springframework.data.repository.CrudRepository

interface RestaurantRepository: CrudRepository<RestaurantDao, Long> {
}
