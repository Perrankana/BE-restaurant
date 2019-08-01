package com.pickeat.restaurantapp.entities

import javax.persistence.*

@Entity
@Table(name = "Restaurant")
class RestaurantDao(
        @Id @GeneratedValue var id: Long? = null,
        var name: String,
        var address: String,
        var city: String,
        var postcode: String,
        var logo: String,
        var image: String,
        var latitude: Double,
        var longitude: Double
)