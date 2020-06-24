package de.robinbecker.whereto.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import de.robinbecker.whereto.entities.User

data class KuechenArt(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val name: String?
)