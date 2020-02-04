package com.shop.helper.presentation.cities.add

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shop.helper.R
import com.shop.helper.data.network.places.entities.Predictions

class AddNewCityAdapter(private val cities: List<Predictions>) :
    RecyclerView.Adapter<AddNewCityAdapter.CityHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CityHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_add_new_city_item, parent, false)
        return CityHolder(view)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        val item = cities?.get(position)
        holder.setPrimaryName(item.getPrimaryName())
        holder.setSecondaryName(item.getSecondName())
    }

    override fun getItemCount() = cities?.size

    open class CityHolder(private val rootView: View) : RecyclerView.ViewHolder(rootView) {

        private var primaryName = rootView.findViewById<TextView>(R.id.text_view_primary)
        private var secondaryName = rootView.findViewById<TextView>(R.id.text_view_secondary)

        fun setPrimaryName(name: String) {
            primaryName.text = name
        }

        fun setSecondaryName(name: String) {
            secondaryName.text = name
        }
    }

}