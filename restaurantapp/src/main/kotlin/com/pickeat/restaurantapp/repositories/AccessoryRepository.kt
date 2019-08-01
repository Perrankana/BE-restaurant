package com.pickeat.restaurantapp.repositories

import com.pickeat.restaurantapp.entities.menu.Accessory
import org.springframework.data.repository.CrudRepository

interface AccessoryRepository : CrudRepository<Accessory, Long>