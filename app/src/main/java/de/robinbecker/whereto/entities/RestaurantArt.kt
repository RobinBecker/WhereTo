package de.robinbecker.whereto.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "restaurantArt")
data class RestaurantArt(
    @PrimaryKey @NotNull var artId: String,
    var restaurantId: String
)