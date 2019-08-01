package com.pickeat.restaurantapp.model.menu

import com.pickeat.restaurantapp.entities.menu.Accessory


data class MenuItem(
        val id: Long? = null,
        val name: String,
        val description: String? = null,
        val position: Int,
        val price: Double,
        val menuCategoryId: Long,
        val optionalAccessories: List<Accessory> = emptyList(),
        val requiredAccessories: List<Accessory> = emptyList()
)