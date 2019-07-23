package com.pickeat.restaurantapp.controllers

import com.pickeat.restaurantapp.repositories.RestaurantRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/restaurant")
class RestaurantsController(private val restaurantRepository: RestaurantRepository) {

    @GetMapping("/")
    fun findAll() = restaurantRepository.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = restaurantRepository.findById(id)
}