package com.pickeat.restaurantapp.repositories

import com.pickeat.restaurantapp.entities.menu.MenuCategory
import org.springframework.data.repository.CrudRepository

interface MenuCategoryRepository : CrudRepository<MenuCategory, Long>