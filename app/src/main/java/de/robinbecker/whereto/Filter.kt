package de.robinbecker.whereto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.navigation.NavigationView


open class Filter : Fragment() {

    private lateinit var viewModel: FilterViewModel

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setMenuVisibility(true)

        var fragmentManager =  parentFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()

        val view: View = inflater.inflate(de.robinbecker.whereto.R.layout.activity_filter, container, false)
        val filter: Button = view.findViewById<View>(de.robinbecker.whereto.R.id.take_filter) as Button
        filter.setOnClickListener {
            fragmentTransaction.replace(de.robinbecker.whereto.R.id.set_filter, Start()).commit()
        }
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FilterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
