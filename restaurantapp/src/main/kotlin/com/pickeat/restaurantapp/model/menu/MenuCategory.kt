package com.pickeat.restaurantapp.model.menu

data class MenuCategory(
        val id: Long? = null,
        val name: String,
        val description: String? = null,
        val position: Int,
        val menuId: Long
)