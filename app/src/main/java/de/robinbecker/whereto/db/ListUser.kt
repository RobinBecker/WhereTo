package de.robinbecker.whereto.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "vorname") val vorname: String?,
    @ColumnInfo(name = "nachname") val nachname: String?,
    @ColumnInfo(name = "email") val email: String?
)

