package com.pickeat.restaurantapp.controllers

import com.pickeat.restaurantapp.entities.mappers.toDomain
import com.pickeat.restaurantapp.model.menu.Menu
import com.pickeat.restaurantapp.model.mappers.toDao
import com.pickeat.restaurantapp.model.menu.MenuCategory
import com.pickeat.restaurantapp.model.menu.MenuItem
import com.pickeat.restaurantapp.repositories.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/restaurant")
class MenuController(
        private val menuRepository: MenuRepository,
        private val restaurantRepository: RestaurantRepository,
        private val menuCategoryRepository: MenuCategoryRepository,
        private val menuItemRepository: MenuItemRepository,
        private val accessoryRepository: AccessoryRepository
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

    private fun findMenuCategories(menu: Menu): List<MenuCategory> =
            menuCategoryRepository.findAllByMenuId(menu.id!!)
                    .toDomain()
                    .map {
                        it.copy(menuItems = findMenuItems(it),
                                optionalAccessories = findAccessoriesByMenuCategory(it, true),
                                requiredAccessories = findAccessoriesByMenuCategory(it, false))
                    }

    private fun findMenuItems(menuCategory: MenuCategory): List<MenuItem> =
            menuItemRepository.findAllByMenuCategoryId(menuCategory.id!!)
                    .toDomain()
                    .map {
                        it.copy(optionalAccessories = findAccessoriesByMenuItem(it, true),
                                requiredAccessories = findAccessoriesByMenuItem(it, false))
                    }

    private fun findAccessoriesByMenuCategory(menuCategory: MenuCategory, optional: Boolean) =
            accessoryRepository.findAllByMenuCategoryIdAndOptional(menuCategory.id!!, optional)
                    .toDomain()

    private fun findAccessoriesByMenuItem(menuItem: MenuItem, optional: Boolean) =
            accessoryRepository.findAllByMenuItemIdAndOptional(menuItem.id!!, optional)
                    .toDomain()
}