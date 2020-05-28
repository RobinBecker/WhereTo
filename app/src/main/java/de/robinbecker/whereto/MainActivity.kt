package de.robinbecker.whereto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    lateinit var reservationsList: ReservationsListFragment
    lateinit var startFragment : StartFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout=findViewById(R.id.drawer_layout)
        navView= findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout,toolbar, 0,0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
        
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_search -> {
                Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_settings -> {
                setContentView(R.layout.activity_filter)
            }
            R.id.nav_chat -> {
                setContentView(R.layout.activity_restaurant_detail)
            }
            R.id.nav_reservations -> {
              // reservationsList = ReservationsListFragment()
                setContentView(R.layout.activity_view_reservations_list)
                /*supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.start_page, reservationsList)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()*/
            }
            R.id.nav_rating -> {
                Toast.makeText(this, "Rating clicked", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
