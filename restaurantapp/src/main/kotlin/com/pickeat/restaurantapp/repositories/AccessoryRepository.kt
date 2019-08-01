package com.pickeat.restaurantapp.repositories

import com.pickeat.restaurantapp.entities.menu.AccessoryDao
import org.springframework.data.repository.CrudRepository

interface AccessoryRepository : CrudRepository<AccessoryDao, Long> {
    fun findAllByMenuCategoryIdAndOptional(menuCategoryId: Long, optional: Boolean): List<AccessoryDao>
    fun findAllByMenuItemIdAndOptional(menuItemId: Long, optional: Boolean): List<AccessoryDao>
}