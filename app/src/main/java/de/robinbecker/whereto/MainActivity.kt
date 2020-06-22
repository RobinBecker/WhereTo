package de.robinbecker.whereto

import android.os.AsyncTask
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = AccountRoomDatabase.getDatabase(this)!!
        val initData = InitData()

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        val filter: TextView = findViewById(R.id.filter)
        filter.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_layout, Filter()).addToBackStack("back").commit()
        }

        val random: Button = findViewById(R.id.random)
        random.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.drawer_layout, RestaurantDetail()).addToBackStack("back").commit()
        }

        AsyncTask.execute {
            run {

                // ---Benutze das unten beim ersten Mal Starten mit den neuen DB-Inhalten---
                //db.clearAllTables()

                // Datenbank mit Test Daten füllen
                initData.loadDatabase(db)

                // Werk auf main (nur fuer Entwicklung)
                val restaurant = db.whereToDAO().getAllRestaurants()
                println("hjsdfkjsdhdfkjsddfhf" + restaurant[2].name)
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_search -> {
                Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_settings -> {
                Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_chat -> {
                Toast.makeText(this, "Chat clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_reservations -> {
                Toast.makeText(this, "Reservations clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_rating -> {
                Toast.makeText(this, "Rating clicked", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
