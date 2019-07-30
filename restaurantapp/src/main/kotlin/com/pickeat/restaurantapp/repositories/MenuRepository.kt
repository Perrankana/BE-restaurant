package com.pickeat.restaurantapp.repositories

import com.pickeat.restaurantapp.entities.menu.Menu
import org.springframework.data.repository.CrudRepository

interface MenuRepository : CrudRepository<Menu, Long>