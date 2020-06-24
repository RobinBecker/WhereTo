package de.robinbecker.whereto.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
open class User(
    @PrimaryKey val id: Int,
    var vorname: String,
    var nachname: String,
    var email: String
)
