package com.pickeat.restaurantapp.controllers

import com.pickeat.restaurantapp.entities.mappers.toDomain
import com.pickeat.restaurantapp.model.Menu
import com.pickeat.restaurantapp.model.mappers.toDao
import com.pickeat.restaurantapp.repositories.MenuRepository
import com.pickeat.restaurantapp.repositories.RestaurantRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/restaurant")
class MenuController(
        private val menuRepository: MenuRepository,
        private val restaurantRepository: RestaurantRepository
) {

    @GetMapping("/{restaurantId}/menu")
    fun findAll(@PathVariable restaurantId: Long) =
            menuRepository.findAllByRestaurantId(restaurantId).toDomain()

    @GetMapping("/{restaurantId}/menu/{id}")
    fun findById(@PathVariable restaurantId: Long, @PathVariable id: Long) =
            menuRepository.findById(id).get().toDomain()

    @PutMapping("/{restaurantId}/menu")
    fun putList(@RequestBody menu: Menu, @PathVariable restaurantId: Long) {
        val restaurant = restaurantRepository.findById(restaurantId).get()
        menuRepository.save(menu.toDao(restaurant))
    }
}