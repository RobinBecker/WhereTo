package de.robinbecker.whereto.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import de.robinbecker.whereto.entities.User

@Entity(tableName = "Freunde",
    foreignKeys = [
        ForeignKey(entity = User::class,
            parentColumns = ["uid"],
            childColumns = ["userId1"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(entity = User::class,
            parentColumns = ["uid"],
            childColumns = ["userId2"],
            onDelete = ForeignKey.CASCADE
        )

    ])
data class Freunde(
    @ColumnInfo(name = "userId1") val userId1: String?,
    @ColumnInfo(name = "userId2") val userId2: String?
)
