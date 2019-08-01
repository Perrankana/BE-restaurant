package com.pickeat.restaurantapp.repositories

import com.pickeat.restaurantapp.entities.menu.MenuDao
import org.springframework.data.repository.CrudRepository

interface MenuRepository : CrudRepository<MenuDao, Long> {
    fun findAllByRestaurantId(restaurantId: Long): List<MenuDao>
}