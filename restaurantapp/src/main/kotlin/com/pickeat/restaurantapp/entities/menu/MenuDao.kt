package com.pickeat.restaurantapp.entities.menu

import com.pickeat.restaurantapp.entities.RestaurantDao
import javax.persistence.*

@Entity
@Table(name = "Menu")
data class MenuDao(
        @Id @GeneratedValue var id: Long? = null,
        @ManyToOne
        @JoinColumn(name= "restaurant_id", nullable = false)
        var restaurant: RestaurantDao,
        var name: String? = null,
        var description: String? = null
)