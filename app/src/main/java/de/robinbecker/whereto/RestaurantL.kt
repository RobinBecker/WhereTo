package de.robinbecker.whereto

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.common.reflect.Reflection.getPackageName
import de.robinbecker.whereto.entities.Restaurant


class RestaurantL : Fragment() {

    companion object {
        fun newInstance() = RestaurantL()
    }

    private lateinit var viewModel: RestaurantLViewModel
    lateinit var restaurants: List<Restaurant>
    private lateinit var kind: String
    private lateinit var price: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.activity_restaurant_list, container, false)
        val db = activity?.let { AccountRoomDatabase.getDatabase(it) }!!

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

        AsyncTask.execute {
            run {
                restaurants = db.whereToDAO().getFilteredRestaurants(kind, price)
            }
            for ((index, value) in restaurants.withIndex()) {
                val textName = "rs_" + (index+1).toString()
                val textKind = "kind_" + (index+1).toString()
                val textKitchen = "kitchen_" + (index+1).toString()
                val textPrice = "price_" + (index+1).toString()

                val idName = resources.getIdentifier(textName, "id", context?.packageName)
                val idKind = resources.getIdentifier(textKind, "id", context?.packageName)
                val idKitchen = resources.getIdentifier(textKitchen, "id", context?.packageName)
                val idPrice = resources.getIdentifier(textPrice, "id", context?.packageName)

                val name: TextView = view.findViewById(idName)
                val kindView: TextView = view.findViewById(idKind)
                val kitchenView: TextView = view.findViewById(idKitchen)
                val priceView: TextView = view.findViewById(idPrice)

                println(name.append(value.name))
                println(kindView.append(value.kind))
                println(kitchenView.append(value.kitchen))
                println(priceView.append(value.price_range))
            }
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RestaurantLViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
