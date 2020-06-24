package de.robinbecker.whereto.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


    @Entity(tableName = "restaurant")
    data class Restaurant(
        @PrimaryKey val id: Int,
        var name: String,
        var phone: String,
        var street: String,
        var plz: String,
        var location: String,
        var price_range: String,
        var kind: String,
        var kitchen: String
    )

