package com.pickeat.restaurantapp.entities.mappers

import com.pickeat.restaurantapp.entities.menu.MenuDao
import com.pickeat.restaurantapp.model.Menu

fun List<MenuDao>.toDomain(): List<Menu> =
        map { it.toDomain() }

fun MenuDao.toDomain(): Menu =
        Menu(id, restaurant.id!!, name, description)