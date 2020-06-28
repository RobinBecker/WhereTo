package de.robinbecker.whereto.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "freunde",
    primaryKeys = ["userId1", "userId2"]
    )
data class Freunde(
    @NotNull var userId1: String,
    @NotNull var userId2: String
)