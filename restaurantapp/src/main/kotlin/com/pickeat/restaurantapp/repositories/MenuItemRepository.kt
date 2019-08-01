package com.pickeat.restaurantapp.repositories

import com.pickeat.restaurantapp.entities.menu.MenuItemDao
import org.springframework.data.repository.CrudRepository

interface MenuItemRepository : CrudRepository<MenuItemDao, Long> {
    fun findAllByMenuCategoryId(menuCategoryId: Long): List<MenuItemDao>
}