package com.pickeat.restaurantapp.model

import com.pickeat.restaurantapp.entities.menu.MenuCategory

data class Menu(
        val id: Long? = null,
        val restaurantId: Long,
        val name: String? = null,
        val description: String? = null,
        val menuCategories: List<MenuCategory>? = null
)