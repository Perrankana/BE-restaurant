package com.pickeat.restaurantapp.entities.mappers

import com.pickeat.restaurantapp.entities.menu.MenuItemDao
import com.pickeat.restaurantapp.model.menu.MenuItem

fun List<MenuItemDao>.toDomain(): List<MenuItem> =
        map { it.toDomain() }

fun MenuItemDao.toDomain(): MenuItem =
        MenuItem(id, name, description, position, price, menuCategory.id!!)