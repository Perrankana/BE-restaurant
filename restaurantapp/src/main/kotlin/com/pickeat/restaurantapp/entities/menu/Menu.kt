package com.pickeat.restaurantapp.entities.menu

import com.pickeat.restaurantapp.entities.Restaurant
import javax.persistence.*

@Entity
data class Menu(
        @Id @GeneratedValue var id: Long? = null,
        @ManyToOne
        @JoinColumn(name= "restaurant_id", nullable = false)
        var restaurant: Restaurant,
        var name: String? = null,
        var description: String? = null
)