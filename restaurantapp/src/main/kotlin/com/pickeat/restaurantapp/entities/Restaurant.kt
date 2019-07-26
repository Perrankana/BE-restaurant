package com.pickeat.restaurantapp.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Restaurant(
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