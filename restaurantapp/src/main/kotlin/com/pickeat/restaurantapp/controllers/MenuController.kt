package com.pickeat.restaurantapp.controllers

import com.pickeat.restaurantapp.entities.menu.MenuDao
import com.pickeat.restaurantapp.entities.menu.MenuCategory
import com.pickeat.restaurantapp.repositories.MenuRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/restaurant")
class MenuController(private val menuRepository: MenuRepository) {

    @GetMapping("/{restaurantId}/menu")
    fun findAll(@PathVariable restaurantId: Long) = menuRepository.findAllByRestaurantId(restaurantId)

    @GetMapping("/{restaurantId}/menu/{id}")
    fun findById(@PathVariable restaurantId: Long, @PathVariable id: Long) = menuRepository.findById(id)

    @PutMapping("/{restaurantId}/menu")
    fun putList(@RequestBody menuDao: MenuDao) = menuRepository.save(menuDao)
}