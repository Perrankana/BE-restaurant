package com.pickeat.restaurantapp.controllers

import com.ninjasquad.springmockk.MockkBean
import com.pickeat.restaurantapp.entities.Restaurant
import com.pickeat.restaurantapp.repositories.RestaurantRepository
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.util.*

@WebMvcTest
class RestaurantControllerTests(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var restaurantRepository: RestaurantRepository

    @Test
    fun `List restaurants`() {
        val restaurant1 = Restaurant(
                name = "100 Montaditos",
                address = "Rambla del Poblenou",
                city = "Barcelona",
                postcode = "08005",
                logo = "https://firebasestorage.googleapis.com/v0/b/wannaeat-d2d6a.appspot.com/o/restaurants%2Flogos%2F100MONTADITOS-LOGO.png?alt=media&token=3bd549f4-cd5b-45fb-af90-cbc00f8e3455",
                image = "https://firebasestorage.googleapis.com/v0/b/wannaeat-d2d6a.appspot.com/o/restaurants%2Fmontaditos-main.jpg?alt=media&token=b39f36ac-a667-4b64-9c51-b25751ec69a8",
                latitude = 41.401283,
                longitude = 2.198988)

        val restaurant2 = Restaurant(
                name = "Timesburg",
                address = "Carrer Pujades, 168",
                city = "Barcelona",
                postcode = "08005",
                logo = "https://firebasestorage.googleapis.com/v0/b/wannaeat-d2d6a.appspot.com/o/restaurants%2Flogos%2FTIMESBURG-LOGO.png?alt=media&token=f1336ebe-8ecb-4f45-876d-0ae6d89829ef",
                image = "https://firebasestorage.googleapis.com/v0/b/wannaeat-d2d6a.appspot.com/o/restaurants%2Ftimesburg_main.jpg?alt=media&token=5e718640-a6b0-4dfa-a1d1-74f778c4f20c",
                latitude = 41.400741,
                longitude = 2.197532)

        every { restaurantRepository.findAll() } returns listOf(restaurant1, restaurant2)
        mockMvc.perform(get("/api/restaurant/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("\$.[0].name").value(restaurant1.name))
                .andExpect(jsonPath("\$.[0].address").value(restaurant1.address))
                .andExpect(jsonPath("\$.[0].city").value(restaurant1.city))
                .andExpect(jsonPath("\$.[0].postcode").value(restaurant1.postcode))
                .andExpect(jsonPath("\$.[0].logo").value(restaurant1.logo))
                .andExpect(jsonPath("\$.[0].image").value(restaurant1.image))
                .andExpect(jsonPath("\$.[0].latitude").value(restaurant1.latitude))
                .andExpect(jsonPath("\$.[0].longitude").value(restaurant1.longitude))
                .andExpect(jsonPath("\$.[1].name").value(restaurant2.name))
                .andExpect(jsonPath("\$.[1].address").value(restaurant2.address))
                .andExpect(jsonPath("\$.[1].city").value(restaurant2.city))
                .andExpect(jsonPath("\$.[1].postcode").value(restaurant2.postcode))
                .andExpect(jsonPath("\$.[1].logo").value(restaurant2.logo))
                .andExpect(jsonPath("\$.[1].image").value(restaurant2.image))
                .andExpect(jsonPath("\$.[1].latitude").value(restaurant2.latitude))
                .andExpect(jsonPath("\$.[1].longitude").value(restaurant2.longitude))

    }

    @Test
    fun `get restaurant by id`() {
        val id = 1L

        val restaurant1 = Restaurant(
                id = id,
                name = "100 Montaditos",
                address = "Rambla del Poblenou",
                city = "Barcelona",
                postcode = "08005",
                logo = "https://firebasestorage.googleapis.com/v0/b/wannaeat-d2d6a.appspot.com/o/restaurants%2Flogos%2F100MONTADITOS-LOGO.png?alt=media&token=3bd549f4-cd5b-45fb-af90-cbc00f8e3455",
                image = "https://firebasestorage.googleapis.com/v0/b/wannaeat-d2d6a.appspot.com/o/restaurants%2Fmontaditos-main.jpg?alt=media&token=b39f36ac-a667-4b64-9c51-b25751ec69a8",
                latitude = 41.401283,
                longitude = 2.198988)

        every { restaurantRepository.findById(id) } returns Optional.of(restaurant1)
        mockMvc.perform(get("/api/restaurant/$id").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("\$.name").value(restaurant1.name))
                .andExpect(jsonPath("\$.address").value(restaurant1.address))
                .andExpect(jsonPath("\$.city").value(restaurant1.city))
                .andExpect(jsonPath("\$.postcode").value(restaurant1.postcode))
                .andExpect(jsonPath("\$.logo").value(restaurant1.logo))
                .andExpect(jsonPath("\$.image").value(restaurant1.image))
                .andExpect(jsonPath("\$.latitude").value(restaurant1.latitude))
                .andExpect(jsonPath("\$.longitude").value(restaurant1.longitude))

    }
}