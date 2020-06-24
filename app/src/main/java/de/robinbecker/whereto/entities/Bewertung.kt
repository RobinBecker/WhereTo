package de.robinbecker.whereto.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "bewertung",
primaryKeys = ["userId" ,"restaurantId"])
data class Bewertung(
    @NotNull var userId: String,
    @NotNull var restaurantId: String,
    var bewertung: String
)