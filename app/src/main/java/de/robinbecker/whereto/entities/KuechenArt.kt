package de.robinbecker.whereto.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kuechenArt")
open class KuechenArt(
    @PrimaryKey val id: Int,
    var name: String
)