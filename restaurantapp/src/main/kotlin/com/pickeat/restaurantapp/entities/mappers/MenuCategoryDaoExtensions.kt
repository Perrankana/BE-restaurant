package com.pickeat.restaurantapp.entities.mappers

import com.pickeat.restaurantapp.entities.menu.MenuCategoryDao
import com.pickeat.restaurantapp.model.menu.MenuCategory

fun List<MenuCategoryDao>.toDomain(): List<MenuCategory> =
        map { it.toDomain() }

fun MenuCategoryDao.toDomain(): MenuCategory =
        MenuCategory(id, name, description, position, menu.id!!)