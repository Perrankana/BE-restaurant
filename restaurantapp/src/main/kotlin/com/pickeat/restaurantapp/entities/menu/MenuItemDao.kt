package com.pickeat.restaurantapp.entities.menu

import javax.persistence.*

@Entity
@Table(name = "MenuItem")
data class MenuItemDao(
        @Id @GeneratedValue var id: Long? = null,
        var name: String,
        var description: String? = null,
        var position: Int,
        var price: Double,
        @ManyToOne
        @JoinColumn(name= "menu_category_id", nullable = false)
        var menuCategory: MenuCategoryDao
)