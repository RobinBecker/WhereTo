package de.robinbecker.whereto

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders


open class Filter : Fragment() {

    private lateinit var viewModel: FilterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setMenuVisibility(true)
        val mActivity: Activity? = this.activity
        val view: View = inflater.inflate(R.layout.activity_filter, container, false)
        val filter: Button = view.findViewById<View>(de.robinbecker.whereto.R.id.take_filter) as Button

        val kindSpinner: Spinner = view.findViewById(R.id.kind)
        kindSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val kind = parent.getItemAtPosition(position)
                MainActivity.kind = kind.toString()
            }}

        val priceSpinner: Spinner = view.findViewById(R.id.dropdown_preis)
        priceSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val price = parent.getItemAtPosition(position)
                MainActivity.price = price.toString()
            }}

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
