package com.pickeat.restaurantapp.controllers

import com.pickeat.restaurantapp.entities.mappers.toDomain
import com.pickeat.restaurantapp.model.menu.Menu
import com.pickeat.restaurantapp.model.mappers.toDao
import com.pickeat.restaurantapp.model.menu.MenuCategory
import com.pickeat.restaurantapp.model.menu.MenuItem
import com.pickeat.restaurantapp.repositories.MenuCategoryRepository
import com.pickeat.restaurantapp.repositories.MenuItemRepository
import com.pickeat.restaurantapp.repositories.MenuRepository
import com.pickeat.restaurantapp.repositories.RestaurantRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/restaurant")
class MenuController(
        private val menuRepository: MenuRepository,
        private val restaurantRepository: RestaurantRepository,
        private val menuCategoryRepository: MenuCategoryRepository,
        private val menuItemRepository: MenuItemRepository
) {

    @GetMapping("/{restaurantId}/menu")
    fun findAll(@PathVariable restaurantId: Long) =
            menuRepository.findAllByRestaurantId(restaurantId)
                    .toDomain()
                    .map {
                        it.copy(menuCategories = findMenuCategories(it))
                    }

    @GetMapping("/{restaurantId}/menu/{id}")
    fun findById(@PathVariable restaurantId: Long, @PathVariable id: Long) =
            menuRepository.findById(id).get()
                    .toDomain()
                    .let {
                        it.copy(menuCategories = findMenuCategories(it))
                    }

    @PutMapping("/{restaurantId}/menu")
    fun putList(@RequestBody menu: Menu, @PathVariable restaurantId: Long) {
        val restaurant = restaurantRepository.findById(restaurantId).get()
        menuRepository.save(menu.toDao(restaurant))
    }

    private fun findMenuCategories(menu: Menu): List<MenuCategory> {
        return menuCategoryRepository.findAllByMenuId(menu.id!!)
                .toDomain()
                .map {
                    it.copy(menuItems = findMenuItems(it))
                }
    }

    private fun findMenuItems(menuCategory: MenuCategory): List<MenuItem> {
        return menuItemRepository.findAllByMenuCategoryId(menuCategory.id!!)
                .toDomain()
    }
}