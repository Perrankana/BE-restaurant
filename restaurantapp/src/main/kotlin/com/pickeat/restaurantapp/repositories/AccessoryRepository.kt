package com.pickeat.restaurantapp.repositories

import com.pickeat.restaurantapp.entities.menu.Accessory
import com.pickeat.restaurantapp.entities.menu.MenuItem
import org.springframework.data.repository.CrudRepository

interface AccessoryRepository : CrudRepository<Accessory, Long>