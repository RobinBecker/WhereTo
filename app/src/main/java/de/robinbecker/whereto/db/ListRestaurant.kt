package de.robinbecker.whereto.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import de.robinbecker.whereto.entities.User

@Entity(tableName = "restaurant",
    foreignKeys = [
    ForeignKey(entity = PLZ::class,
        parentColumns = ["plz"],
        childColumns = ["plz"],
        onDelete = ForeignKey.CASCADE)]
    )
data class Restaurant(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "restaurant_name") val restaurantName: String?,
    @ColumnInfo(name = "telefonnummer") val telefonnummer: String?,
    @ColumnInfo(name = "strasse") val strasse: String?,
    @ColumnInfo(name = "plz") val plz: String?

)