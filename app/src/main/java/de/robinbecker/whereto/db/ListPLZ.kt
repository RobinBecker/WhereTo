package de.robinbecker.whereto.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PLZ (
    @PrimaryKey var plz: String,
    @ColumnInfo(name = "ort") var ort: String
)