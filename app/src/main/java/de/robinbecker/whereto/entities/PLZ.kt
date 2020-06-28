package de.robinbecker.whereto.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plz")
data class PLZ(
@PrimaryKey val plz: Int,
var ort: String
)