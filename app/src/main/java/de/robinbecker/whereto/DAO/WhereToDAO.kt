package de.robinbecker.whereto.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import de.robinbecker.whereto.entities.KuechenArt
import de.robinbecker.whereto.entities.Reservierung
import de.robinbecker.whereto.entities.Password
import de.robinbecker.whereto.entities.RestaurantArt
import de.robinbecker.whereto.entities.Restaurant
import de.robinbecker.whereto.entities.User


@Dao
interface WhereToDAO {

    // Restaurant
    @Insert
    fun insertRestaurant(restaurant: Restaurant)

    @Query("SELECT * FROM restaurant")
    fun getAllRestaurants(): List<Restaurant>

    /* @Query("SELECT * from kuenstler WHERE kuenstler.mail=:mail")
    fun getKuenstler(mail: String): Kuenstler*/

    // USER
    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

    //USER Login
    @Query("SELECT * FROM user WHERE email LIKE :mail")
    fun getUserForEmail(mail: String) : User


    //Reservierung
    @Insert
    fun insertReservierung(reservierung: Reservierung)

    @Query("SELECT * FROM reservierung")
    fun getAllReservierungen(): List<Reservierung>

    //Passwort
    @Insert
    fun insertPasswortForUser(password: Password)

    @Query("SELECT * FROM password WHERE userId LIKE :pass")
    fun getPasswordForUser(pass: String): Password

    //KuechenArt
    @Insert
    fun insertKuechenArt(kuechenArt: KuechenArt)

    @Query("SELECT * FROM kuechenart")
    fun getAllKuechenArt(): List<KuechenArt>

    //RestaurantArt
    @Insert
    fun insertRestaurantArt(restaurantArt: RestaurantArt)

    @Query("SELECT * FROM RestaurantArt")
    fun getAllRestaurantArts(): List<RestaurantArt>
}

