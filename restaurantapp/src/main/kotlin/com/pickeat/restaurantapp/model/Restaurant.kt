package com.pickeat.restaurantapp.model

class Restaurant(
        val id: Long? = null,
        val name: String,
        val address: String,
        val city: String,
        val postcode: String,
        val logo: String,
        val image: String,
        val latitude: Double,
        val longitude: Double
)