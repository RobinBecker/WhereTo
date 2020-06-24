package de.robinbecker.whereto.entities

import androidx.room.Entity

@Entity(tableName = "freunde")
open class Freunde(
    var userId1: String,
    var uderId2: String
)