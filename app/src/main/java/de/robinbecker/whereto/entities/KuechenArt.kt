package de.robinbecker.whereto.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kuechenArt")
data class KuechenArt(
    @PrimaryKey val id: Int,
    var name: String
)