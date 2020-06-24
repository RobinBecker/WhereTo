package de.robinbecker.whereto.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import de.robinbecker.whereto.entities.User

@Entity(tableName = "Password",
    foreignKeys = [
        ForeignKey(entity = User::class,
            parentColumns = ["uid"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )])
data class Password(
    @ColumnInfo(name = "password") val password: String?,
    @ColumnInfo(name = "userId") val userId: String?
)