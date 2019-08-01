package com.pickeat.restaurantapp.controllers

import com.pickeat.restaurantapp.entities.mappers.toDomain
import com.pickeat.restaurantapp.model.Restaurant
import com.pickeat.restaurantapp.model.mappers.toDao
import com.pickeat.restaurantapp.repositories.RestaurantRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/restaurant")
class RestaurantsController(private val restaurantRepository: RestaurantRepository) {

    @GetMapping("/")
    fun findAll() = restaurantRepository.findAll().toList().toDomain()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = restaurantRepository.findById(id).get().toDomain()

    @PutMapping("/")
    fun putOne(@RequestBody restaurant: Restaurant) = restaurantRepository.save(restaurant.toDao())
}