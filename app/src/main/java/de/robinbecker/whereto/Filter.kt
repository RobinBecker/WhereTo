package de.robinbecker.whereto

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
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
        val mActivity: Activity? = this.activity
        val view: View = inflater.inflate(R.layout.activity_filter, container, false)
        val filter: Button = view.findViewById<View>(de.robinbecker.whereto.R.id.take_filter) as Button
        filter.setOnClickListener {
            Toast.makeText(mActivity, "Filter were set", Toast.LENGTH_SHORT).show()
        }
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FilterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
