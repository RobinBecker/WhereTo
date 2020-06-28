package de.robinbecker.whereto

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import de.robinbecker.whereto.entities.Restaurant


class RestaurantDetail : Fragment(), OnMapReadyCallback {
    private var googleMap: GoogleMap? = null
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

        val mapView: MapView = view.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RestaurantDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

     override fun onMapReady(p0: GoogleMap?) {
        googleMap=p0

        //Adding markers to map

        val latLng=LatLng(28.6139,77.2090)
        val markerOptions:MarkerOptions = MarkerOptions().position(latLng).title("New Delhi")

        // moving camera and zoom map

        val zoomLevel = 12.0f //This goes up to 21


        googleMap.let {
            it!!.addMarker(markerOptions)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel))
        }
    }
}
