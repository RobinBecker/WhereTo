package de.robinbecker.whereto.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import de.robinbecker.whereto.entities.User


@Entity(tableName = "RestaurantArt",
    foreignKeys = [
        ForeignKey(entity = KuechenArt::class,
            parentColumns = ["uid"],
            childColumns = ["artId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(entity =  Restaurant::class,
            parentColumns = ["uid"],
            childColumns = ["restaurantId"],
            onDelete = ForeignKey.CASCADE)
    ])
data class RestaurantArt(
    @ColumnInfo(name = "password") val artId: String?,
    @ColumnInfo(name = "userId") val restaurantId: String?
)