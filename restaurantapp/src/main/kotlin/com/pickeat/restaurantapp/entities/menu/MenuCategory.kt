package com.pickeat.restaurantapp.entities.menu

import javax.persistence.*

@Entity
data class MenuCategory(
        @Id @GeneratedValue var id: Long? = null,
        var name: String,
        var description: String,
        var position: Int,
        @ManyToOne
        @JoinColumn(name= "menu_id", nullable = false)
        var menu: Menu
//        @OneToMany var menuItems: List<MenuItem>,
//        @OneToMany var requiredAccessories: List<Accessory>,
//        @OneToMany var optionalAccessories: List<Accessory>
)