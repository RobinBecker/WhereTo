package de.robinbecker.whereto

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.robinbecker.whereto.DAO.WhereToDAO
import de.robinbecker.whereto.entities.Restaurant

@Database(
    entities = arrayOf(
        Restaurant::class
    ),
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

/*

class Database(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, " +
                    "PHONE TEXT, STREET TEXT, PLZ TEXT, LOCATION TEXT, PRICE_RANGE TEXT, KIND TEXT, KITCHEN TEXT)"
        )
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    companion object {
        const val DATABASE_NAME = "Restaurant.db"
        const val TABLE_NAME = "restaurant_table"
        const val COL_1 = "ID"
        const val COL_2 = "NAME"
        const val COL_3 = "PHONE"
        const val COL_4 = "STREET"
        const val COL_5 = "PLZ"
        const val COL_6 = "LOCATION"
        const val COL_8 = "PRICE_RANGE"
        const val COL_9 = "KIND"
        const val COL_10 = "KITCHEN"
    }

    init {
        val db = this.writableDatabase
    }
}
*/