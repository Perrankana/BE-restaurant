package com.pickeat.restaurantapp.entities.menu

import javax.persistence.*

@Entity
data class MenuCategory(
        @Id @GeneratedValue var id: Long? = null,
        var name: String,
        var description: String? = null,
        var position: Int,
        @ManyToOne
        @JoinColumn(name= "menu_id", nullable = false)
        var menuDao: MenuDao
)