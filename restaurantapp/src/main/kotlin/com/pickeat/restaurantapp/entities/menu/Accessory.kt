package com.pickeat.restaurantapp.entities.menu

import javax.persistence.*

@Entity
data class Accessory(
        @Id @GeneratedValue var id: Long? = null,
        var groupId: Int,
        var groupName: String,
        var name: String,
        var position: Int,
        var price: Double,
        var optional: Boolean,
        @ManyToOne
        @JoinColumn(name= "menu_category_id", nullable = true)
        var menuCategory: MenuCategoryDao? = null,
        @ManyToOne
        @JoinColumn(name= "menu_item_id", nullable = true)
        var menuItem: MenuItem? = null
)
