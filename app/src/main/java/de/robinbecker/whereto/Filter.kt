package de.robinbecker.whereto

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders


open class Filter : Fragment() {

    private lateinit var viewModel: FilterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var fragmentManager =  parentFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()

        val view: View = inflater.inflate(de.robinbecker.whereto.R.layout.activity_filter, container, false)
        val filter: Button = view.findViewById<View>(de.robinbecker.whereto.R.id.take_filter) as Button
        filter.setOnClickListener {
            fragmentTransaction.replace(de.robinbecker.whereto.R.id.set_filter, StartFragment()).commit()
        }
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FilterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
