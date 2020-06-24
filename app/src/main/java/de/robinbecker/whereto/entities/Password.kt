package de.robinbecker.whereto.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "password")
open class Password(
    var password: String,
    var userId: String
)