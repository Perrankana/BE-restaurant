package com.pickeat.restaurantapp.entities.menu

import javax.persistence.*

@Entity
data class MenuItem(
        @Id @GeneratedValue var id: Long? = null,
        var name: String,
        var description: String? = null,
        var position: Int,
        var price: Double,
        @ManyToOne
        @JoinColumn(name= "menu_category_id", nullable = false)
        var menuCategory: MenuCategoryDao
//        @OneToMany var requiredAccessories: List<Accessory>,
//        @OneToMany var optionalAccessories: List<Accessory>
)