package com.shop.helper.presentation.cities.add

import com.shop.helper.data.network.places.entities.Predictions
import com.shop.helper.presentation.base.BaseView

interface AddNewCityView : BaseView {

    fun displayCities(cities: List<Predictions>?)

}