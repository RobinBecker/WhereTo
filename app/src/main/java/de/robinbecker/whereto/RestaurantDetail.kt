package de.robinbecker.whereto

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
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
        AsyncTask.execute {
            run {
                restaurants = db.whereToDAO().getAllRestaurants()
                val random = restaurants.random()
                val name: TextView = view.findViewById(R.id.restaurant_name)
                val strasse: TextView = view.findViewById(R.id.restaurant_strasse)
                val ort: TextView = view.findViewById(R.id.restaurant_plz)
                name.append(random.name)
                strasse.append(random.street)
                ort.append(random.plz + " " + random.location)
            }
        }
        var mapView: MapView = view.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)

        mapView.getMapAsync { map ->
            map.animateCamera(
                CameraUpdateFactory.newLatLng(
                    LatLng(
                        52.520008, 13.404954
                    )
                )
            )
        }


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RestaurantDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
