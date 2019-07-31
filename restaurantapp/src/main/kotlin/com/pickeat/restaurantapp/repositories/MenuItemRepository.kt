package com.pickeat.restaurantapp.repositories

import com.pickeat.restaurantapp.entities.menu.MenuItem
import org.springframework.data.repository.CrudRepository

interface MenuItemRepository : CrudRepository<MenuItem, Long>