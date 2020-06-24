package de.robinbecker.whereto.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import de.robinbecker.whereto.entities.User

@Entity(tableName = "Reservierung",
    foreignKeys = [
        ForeignKey(entity = User::class,
            parentColumns = ["uid"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(entity =  Restaurant::class,
            parentColumns = ["uid"],
            childColumns = ["restaurantId"],
            onDelete = ForeignKey.CASCADE)
    ])
data class Reservierung(
    @ColumnInfo(name = "password") val password: String?,
    @ColumnInfo(name = "userId") val userId: String?
)