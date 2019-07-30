package com.pickeat.restaurantapp

import com.pickeat.restaurantapp.entities.Restaurant
import com.pickeat.restaurantapp.entities.menu.Menu
import com.pickeat.restaurantapp.entities.menu.MenuCategory
import com.pickeat.restaurantapp.entities.menu.MenuItem
import com.pickeat.restaurantapp.repositories.MenuCategoryRepository
import com.pickeat.restaurantapp.repositories.MenuRepository
import com.pickeat.restaurantapp.repositories.RestaurantRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RestaurantConfiguration {

    @Bean
    fun databaseInitializer(
            restaurantRepository: RestaurantRepository,
            menuRepository: MenuRepository,
            menuCategoryRepository: MenuCategoryRepository) = ApplicationRunner {
        val restaurant = Restaurant(
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

        restaurantRepository.save(restaurant)
        restaurantRepository.save(restaurant2)

        val menu = Menu(
                restaurant = restaurant,
                name = "menu",
                description = "description"
        )

        menuRepository.save(menu)

        val menuCategory = MenuCategory(
                menu = menu,
                name = "category",
                description = "category description",
                position = 0
        )

        val menuCategory2 = MenuCategory(
                menu = menu,
                name = "category2",
                description = "category 2 description",
                position = 1
        )

        menuCategoryRepository.save(menuCategory)
        menuCategoryRepository.save(menuCategory2)





//        menuRepository
//                .save(
//                        Menu(
//                                restaurantId =
//                        )
//                )
//
//        MenuItem(
//                restaurantId = 1,
//                name = "Menu medio día",
//                description = "Un plato, bebida y postre",
//                position = 0,
//                price = 12.5)
    }
}