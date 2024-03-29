package com.pickeat.restaurantapp.entities.menu

import javax.persistence.*

@Entity
@Table(name = "MenuCategory")
data class MenuCategoryDao(
        @Id @GeneratedValue var id: Long? = null,
        var name: String,
        var description: String? = null,
        var position: Int,
        @ManyToOne
        @JoinColumn(name= "menu_id", nullable = false)
        var menu: MenuDao
)