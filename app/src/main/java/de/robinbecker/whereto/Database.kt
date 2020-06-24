package de.robinbecker.whereto

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.robinbecker.whereto.DAO.WhereToDAO
import de.robinbecker.whereto.entities.*


@Database(
    entities = [
        Restaurant::class,
        Bewertung::class,
        Freunde::class,
        KuechenArt::class,
        Password::class,
        PLZ::class,
        Reservierung::class,
        RestaurantArt::class,
        User::class


    ],
    version = 29,
    exportSchema = false
)
abstract class AccountRoomDatabase : RoomDatabase() {
    abstract fun whereToDAO(): WhereToDAO

    companion object {
        private var INSTANCE: AccountRoomDatabase? = null
        fun getDatabase(context: Context): AccountRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(AccountRoomDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext, AccountRoomDatabase::class.java, "whereTo.db"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}