package com.pickeat.restaurantapp.model.menu

data class Accessory(
        val id: Long? = null,
        val groupId: Int,
        val groupName: String,
        val name: String,
        val position: Int,
        val price: Double,
        val optional: Boolean,
        val menuCategoryId: Long? = null,
        var menuItemId: Long? = null
)
