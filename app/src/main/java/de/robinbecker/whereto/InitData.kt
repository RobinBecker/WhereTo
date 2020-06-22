package de.robinbecker.whereto

import de.robinbecker.whereto.entities.Restaurant

class InitData() {
    private val restaurant1 = Restaurant(
        1,
        "Burger Hut",
        "0721-234567",
        "Kaiserstraße 10",
        "76133",
        "Karlsruhe",
        "niedrig",
        "beliebig",
        "deutsch"
    )

    private val restaurant2 = Restaurant(
        2,
        "Vapiano",
        "0721-234567",
        "Kaiserstraße 10",
        "76133",
        "Karlsruhe",
        "mittel",
        "vegetarisch",
        "spanisch"
    )
    private val restaurant3 = Restaurant(
        3,
        "Asia Grill",
        "0721-234567",
        "Kaiserstraße 10",
        "76133",
        "Karlsruhe",
        "niedrig",
        "beliebig",
        "asiatisch"
    )
    private val restaurant4 = Restaurant(
        4,
        "Zum Hirsch",
        "0721-234567",
        "Kaiserstraße 10",
        "76133",
        "Karlsruhe",
        "hoch",
        "beliebig",
        "deutsch"
    )
    private val restaurant5 = Restaurant(
        5,
        "Kebabi",
        "0721-234567",
        "Kaiserstraße 10",
        "76133",
        "Karlsruhe",
        "mittel",
        "beliebig",
        "türkisch"
    )
    private val restaurant6 = Restaurant(
        6,
        "Besitos",
        "0721-234567",
        "Kaiserstraße 10",
        "76133",
        "Karlsruhe",
        "mittel",
        "beliebig",
        "spanisch"
    )
    private val restaurant7 = Restaurant(
        7,
        "Enchilada",
        "0721-234567",
        "Kaiserstraße 10",
        "76133",
        "Karlsruhe",
        "beliebig",
        "beliebig",
        "mexikanisch"
    )

    private val restaurant8 = Restaurant(
        8,
        "Vegano",
        "0721-234567",
        "Kaiserstraße 10",
        "76133",
        "Karlsruhe",
        "hoch",
        "vegan",
        "deutsch"
    )

    fun loadDatabase(database: AccountRoomDatabase) {

        if (database.whereToDAO().getAllRestaurants().isEmpty()) {
            println("----Insert Init Data----")
            database.clearAllTables()

            // Restaurants anlegen
            database.whereToDAO().insertRestaurant(restaurant1)
            database.whereToDAO().insertRestaurant(restaurant2)
            database.whereToDAO().insertRestaurant(restaurant3)
            database.whereToDAO().insertRestaurant(restaurant4)
            database.whereToDAO().insertRestaurant(restaurant5)
            database.whereToDAO().insertRestaurant(restaurant6)
            database.whereToDAO().insertRestaurant(restaurant7)
            database.whereToDAO().insertRestaurant(restaurant8)
        }

    }

}

