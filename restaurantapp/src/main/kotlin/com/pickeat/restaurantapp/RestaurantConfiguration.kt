package com.pickeat.restaurantapp

import com.pickeat.restaurantapp.entities.RestaurantDao
import com.pickeat.restaurantapp.entities.menu.Accessory
import com.pickeat.restaurantapp.entities.menu.MenuDao
import com.pickeat.restaurantapp.entities.menu.MenuCategoryDao
import com.pickeat.restaurantapp.entities.menu.MenuItem
import com.pickeat.restaurantapp.repositories.*
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RestaurantConfiguration {

    @Bean
    fun databaseInitializer(
            restaurantRepository: RestaurantRepository,
            menuRepository: MenuRepository,
            menuCategoryRepository: MenuCategoryRepository,
            menuItemRepository: MenuItemRepository,
            accessoryRepository: AccessoryRepository
    ) = ApplicationRunner {
        val restaurant = RestaurantDao(
                name = "100 Montaditos",
                address = "Rambla del Poblenou",
                city = "Barcelona",
                postcode = "08005",
                logo = "https://firebasestorage.googleapis.com/v0/b/wannaeat-d2d6a.appspot.com/o/restaurants%2Flogos%2F100MONTADITOS-LOGO.png?alt=media&token=3bd549f4-cd5b-45fb-af90-cbc00f8e3455",
                image = "https://firebasestorage.googleapis.com/v0/b/wannaeat-d2d6a.appspot.com/o/restaurants%2Fmontaditos-main.jpg?alt=media&token=b39f36ac-a667-4b64-9c51-b25751ec69a8",
                latitude = 41.401283,
                longitude = 2.198988)

        val restaurant2 = RestaurantDao(
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

        val menu = MenuDao(
                restaurant = restaurant2,
                name = "Daily menu",
                description = "Great burgers"
        )

        menuRepository.save(menu)

        /*CATEGORY ENSALADA*/

        val menuCategoryEnsalada = MenuCategoryDao(
                menuDao = menu,
                name = "Ensaladas",
                position = 2
        )

        menuCategoryRepository.save(menuCategoryEnsalada)

        val menuEnsaladaTimesburg = MenuItem(
                menuCategory = menuCategoryEnsalada,
                name = "Ensalada Timesburg",
                description = "Brotes de mezclum, nueces, queso de cabra y confitura de arándanos con su vinagreta timesburg.",
                position = 0,
                price = 8.2
        )

        val menuEnsaladaCaesar = MenuItem(
                menuCategory = menuCategoryEnsalada,
                name = "Ensalada Caesar",
                description = "Lechuga francesa, pollo, bacon, croutons y queso parmigiano con vinagreta caesar.",
                position = 1,
                price = 9.9
        )

        menuItemRepository.save(menuEnsaladaTimesburg)
        menuItemRepository.save(menuEnsaladaCaesar)

        /*CATEGORY BOCADILLO*/

        val menuCategoryBocadillos = MenuCategoryDao(
                menuDao = menu,
                name = "Bocadillos",
                position = 3
        )

        menuCategoryRepository.save(menuCategoryBocadillos)

        val menuBocataNordico = MenuItem(
                menuCategory = menuCategoryBocadillos,
                name = "Nórdico (Salmón)",
                description = "Delicioso bocadillo crujiente en pan de cristal, rúcula, salmón, eneldo, salsa tártara y un toque de soja.",
                position = 1,
                price = 6.9
        )

        val menuBocataBellota = MenuItem(
                menuCategory = menuCategoryEnsalada,
                name = "Bellota (Jamón Ibérico)",
                description = "Bocadillo crujiente en pan de cristal, jamón ibérico, tomate y aceite de oliva.",
                position = 0,
                price = 6.5
        )

        menuItemRepository.save(menuBocataNordico)
        menuItemRepository.save(menuBocataBellota)

        /*CATEGORY PATATAS FRITAS*/

        val menuCategoryPatatas = MenuCategoryDao(
                menuDao = menu,
                name = "Patatas Fritas",
                position = 1
        )

        menuCategoryRepository.save(menuCategoryPatatas)

        val menuPatatasRacion = MenuItem(
                menuCategory = menuCategoryPatatas,
                name = "La Ración",
                position = 1,
                price = 6.9
        )

        val menuPatatasKilo = MenuItem(
                menuCategory = menuCategoryPatatas,
                name = "1/2 Kilo",
                position = 1,
                price = 5.8
        )

        menuItemRepository.save(menuPatatasRacion)
        menuItemRepository.save(menuPatatasKilo)

        val accessorySalsaKetchup = Accessory(
                groupId = 0,
                groupName = "Salsas",
                name = "Ketchup",
                position = 1,
                price = 0.0,
                optional = false,
                menuCategory = menuCategoryPatatas
        )

        val accessorySalsaMayo = Accessory(
                groupId = 0,
                groupName = "Salsas",
                name = "Mayonesa",
                position = 0,
                price = 0.0,
                optional = false,
                menuCategory = menuCategoryPatatas
        )

        accessoryRepository.save(accessorySalsaKetchup)
        accessoryRepository.save(accessorySalsaMayo)

        /*CATEGORY BURGERS*/

        val menuCategoryBurgers = MenuCategoryDao(
                menuDao = menu,
                name = "Hamburguesas",
                position = 0,
                description = "Todas nuestras hamburguesas están elaboradas con carnes cuidadosamente seleccionadas, preparadas a la parrilla y AL PUNTO."
        )

        menuCategoryRepository.save(menuCategoryBurgers)

        val accessoryBurger1 = Accessory(
                groupId = 0,
                groupName = "Otras carnes",
                name = "Wagyu",
                position = 1,
                price = 4.5,
                optional = true,
                menuCategory = menuCategoryBurgers
        )

        accessoryRepository.save(accessoryBurger1)

        val accessoryBurger2 = Accessory(
                groupId = 1,
                groupName = "Panes",
                name = "Semilla de Amapola",
                position = 0,
                price = 0.0,
                optional = true,
                menuCategory = menuCategoryBurgers
        )

        accessoryRepository.save(accessoryBurger2)

        val accessoryBurger3 = Accessory(
                groupId = 0,
                groupName = "Otras carnes",
                name = "Carne ecológica",
                position = 0,
                price = 1.0,
                optional = true,
                menuCategory = menuCategoryBurgers
        )

        accessoryRepository.save(accessoryBurger3)

        val menuBurger1 = MenuItem(
                menuCategory = menuCategoryBurgers,
                name = "Paris 95",
                description = "200g de carne 100% vacuno, tomate, lechuga francesa, cebolla, nuestro toque secreto para carnes y mayonesa timesburg.",
                position = 3,
                price = 8.9
        )

        menuItemRepository.save(menuBurger1)

        val menuBurger2 = MenuItem(
                menuCategory = menuCategoryBurgers,
                name = "La Roquefort",
                description = "200g de carne 100% vacuno, salsa roquefort, rúcula, nueces rotas, tomate y mayonesa timesburg.",
                position = 0,
                price = 8.7
        )

        menuItemRepository.save(menuBurger2)

        val accessorySalsaChilli = Accessory(
                groupId = 0,
                groupName = "Salsa",
                name = "Chili",
                position = 1,
                price = 0.6,
                optional = true,
                menuItem = menuBurger2
        )

        accessoryRepository.save(accessorySalsaChilli)

        val accessorySalsa2 = Accessory(
                groupId = 0,
                groupName = "Salsa",
                name = "Guacamole",
                position = 0,
                price = 0.6,
                optional = true,
                menuItem = menuBurger2
        )

        accessoryRepository.save(accessorySalsa2)

        val menuBurger3 = MenuItem(
                menuCategory = menuCategoryBurgers,
                name = "Osaka",
                description = "200g de carne 100% vacuno, mayonesa japonesa, wakame, salsa teriyaki, tomate y lechuga francesa.",
                position = 2,
                price = 6.9
        )

        menuItemRepository.save(menuBurger3)

        val menuBurger4 = MenuItem(
                menuCategory = menuCategoryBurgers,
                name = "Pollo Piri Piri",
                description = "Cortes finos de pechuga de pollo con nuestro aliño piri piri, tomate, rúcula, cebolla y mayonesa timesburg.",
                position = 1,
                price = 6.5
        )

        menuItemRepository.save(menuBurger4)

    }
}