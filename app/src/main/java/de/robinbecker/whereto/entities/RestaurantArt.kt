package de.robinbecker.whereto.entities

import androidx.room.Entity

@Entity(tableName = "passwort")
open class RestaurantArt(
    var artId: String,
    var restaurantId: String
)