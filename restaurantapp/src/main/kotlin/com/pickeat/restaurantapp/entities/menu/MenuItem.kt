package com.pickeat.restaurantapp.entities.menu

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class MenuItem(
        @Id @GeneratedValue var id: Long? = null,
        var name: String,
        var description: String,
        var position: Int,
        var price: Double
//        @OneToMany var requiredAccessories: List<Accessory>,
//        @OneToMany var optionalAccessories: List<Accessory>
)