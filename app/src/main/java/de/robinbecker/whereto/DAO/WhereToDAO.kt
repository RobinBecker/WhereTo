package de.robinbecker.whereto.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import de.robinbecker.whereto.entities.Restaurant

@Dao
interface WhereToDAO {

    // Restaurant
    @Insert
    fun insertRestaurant(restaurant: Restaurant)

    @Query("SELECT * FROM restaurant")
    fun getAllRestaurants(): List<Restaurant>

    /* @Query("SELECT * from kuenstler WHERE kuenstler.mail=:mail")
    fun getKuenstler(mail: String): Kuenstler*/
}