package de.robinbecker.whereto

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    private lateinit var kind: String
    private lateinit var price: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.activity_restaurant_detail, container, false)
        val db = activity?.let { AccountRoomDatabase.getDatabase(it) }!!

        val parameter: List<String> = checkFilterValue()

        AsyncTask.execute {
            run {
                restaurants = db.whereToDAO().getFilteredRestaurants(parameter[0], parameter[1])
            }
            val random = restaurants.random()
            val name: TextView = view.findViewById(R.id.restaurant_name)
            val strasse: TextView = view.findViewById(R.id.restaurant_strasse)
            val ort: TextView = view.findViewById(R.id.restaurant_plz)
            name.append(random.name)
            strasse.append(random.street)
            ort.append(random.plz + " " + random.location)
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

    private fun checkFilterValue(): List<String>{
        val parameter: List<String> = emptyList()

        kind = if (MainActivity.kind != "beliebig"){
            MainActivity.kind
        } else {
            "%"
        }

        price = if (MainActivity.price != "beliebig"){
            MainActivity.price
        } else {
            "%"
        }

        parameter.toMutableList().add(kind)
        parameter.toMutableList().add(price)

        return parameter
    }

}
