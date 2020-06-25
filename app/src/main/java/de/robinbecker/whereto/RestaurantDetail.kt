package de.robinbecker.whereto

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.MapView
import de.robinbecker.whereto.entities.Restaurant


class RestaurantDetail : Fragment() {
    companion object {
        fun newInstance() = RestaurantDetail()
    }

    private lateinit var viewModel: RestaurantDetailViewModel
    lateinit var restaurants: List<Restaurant>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.activity_restaurant_detail, container, false)
        val db = activity?.let { AccountRoomDatabase.getDatabase(it) }!!

        val filterParameter: List<String> = getParameterToFilterRestaurants(view)
        val kitchenParameter: List<Boolean> = getKitchenOfRestaurantsForFilter(view)

        AsyncTask.execute {
            run {
                restaurants = if(filterParameter[0] == "beliebig" && filterParameter[1] == "beliebig" && !kitchenParameter.contains(true)){
                    db.whereToDAO().getAllRestaurants()
                } else {
                    db.whereToDAO().getFilteredRestaurants(filterParameter[0], filterParameter[1], "türkisch")
                }
                val random = restaurants.random()
                val name: TextView = view.findViewById(R.id.restaurant_name)
                val strasse: TextView = view.findViewById(R.id.restaurant_strasse)
                val ort: TextView = view.findViewById(R.id.restaurant_plz)
                name.append(random.name)
                strasse.append(random.street)
                ort.append(random.plz + " " + random.location)
            }
        }
        val mapView: MapView = view.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RestaurantDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun getParameterToFilterRestaurants(view: View) : List<String> {
        val filterParameter: List<String> = emptyList()

        val kindSpinner: Spinner = view.findViewById(R.id.kind)
        val kind: String = kindSpinner.selectedItem.toString()

        val priceSpinner:Spinner = view.findViewById(R.id.dropdown_preis)
        val price: String = priceSpinner.selectedItem.toString()

        filterParameter.toMutableList().add(price)
        filterParameter.toMutableList().add(kind)

        return filterParameter
    }

    private fun getKitchenOfRestaurantsForFilter(view: View) : List<Boolean> {

        val kitchenForFilter: List<Boolean> = emptyList()

        val isItalian: Boolean = view.findViewById<CheckBox>(R.id.radio_italienisch).isChecked
        val isSpain: Boolean = view.findViewById<CheckBox>(R.id.radio_spanisch).isChecked
        val isMexican: Boolean = view.findViewById<CheckBox>(R.id.radio_mexikanisch).isChecked
        val isGerman: Boolean = view.findViewById<CheckBox>(R.id.radio_deutsch).isChecked
        val isTurkish: Boolean = view.findViewById<CheckBox>(R.id.radio_türkisch).isChecked
        val isAsian: Boolean = view.findViewById<CheckBox>(R.id.radio_asiatisch).isChecked

        kitchenForFilter.toMutableList().add(isItalian)
        kitchenForFilter.toMutableList().add(isSpain)
        kitchenForFilter.toMutableList().add(isMexican)
        kitchenForFilter.toMutableList().add(isGerman)
        kitchenForFilter.toMutableList().add(isTurkish)
        kitchenForFilter.toMutableList().add(isAsian)

        return kitchenForFilter
    }

}
