package de.robinbecker.whereto.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "password")
data class Password(
    var password: String,
    @PrimaryKey var userId: String
)