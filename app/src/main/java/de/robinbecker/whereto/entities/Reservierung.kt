package de.robinbecker.whereto.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "reservierung",
primaryKeys = ["userId", "restaurantId"])
data class Reservierung(
    @NotNull var userId: String,
    @NotNull var restaurantId: String
)