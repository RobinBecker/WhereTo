package de.robinbecker.whereto.entities

import androidx.room.Entity

@Entity(tableName = "reservierung")
open class Reservierung(
    var userId: String,
    var restaurantId: String
)