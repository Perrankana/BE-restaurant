package com.pickeat.restaurantapp.entities.mappers

import com.pickeat.restaurantapp.entities.menu.AccessoryDao
import com.pickeat.restaurantapp.model.menu.Accessory

fun List<AccessoryDao>.toDomain(): List<Accessory> =
        map { it.toDomain() }

fun AccessoryDao.toDomain(): Accessory =
        Accessory(id, groupId, groupName, name, position, price, optional, menuCategory?.id, menuItem?.id)