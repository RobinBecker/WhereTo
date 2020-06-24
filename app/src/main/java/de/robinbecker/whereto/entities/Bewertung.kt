package de.robinbecker.whereto.entities

import androidx.room.Entity

@Entity(tableName = "bewertung")
open class Bewertung(
    var userId: String,
    var restaurantId: String,
    var bewertung: String
)