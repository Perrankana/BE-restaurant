package com.pickeat.restaurantapp.controllers

import com.pickeat.restaurantapp.entities.Restaurant
import com.pickeat.restaurantapp.repositories.RestaurantRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/restaurant")
class RestaurantsController(private val restaurantRepository: RestaurantRepository) {

    @GetMapping("/")
    fun findAll() = restaurantRepository.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = restaurantRepository.findById(id)

    @PutMapping("/")
    fun putOne(@RequestBody restaurant: Restaurant) = restaurantRepository.save(restaurant)
}