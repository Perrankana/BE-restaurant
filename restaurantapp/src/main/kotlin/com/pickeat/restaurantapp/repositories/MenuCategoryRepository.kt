package com.pickeat.restaurantapp.repositories

import com.pickeat.restaurantapp.entities.menu.MenuCategoryDao
import org.springframework.data.repository.CrudRepository

interface MenuCategoryRepository : CrudRepository<MenuCategoryDao, Long> {
    fun findAllByMenuId(menuId: Long): List<MenuCategoryDao>
}