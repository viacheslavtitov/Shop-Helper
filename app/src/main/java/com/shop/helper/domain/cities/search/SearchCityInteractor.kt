package com.shop.helper.domain.cities.search

import com.shop.helper.ShopHelperApplication
import com.shop.helper.data.network.base.entities.GooglePlaceStatus
import com.shop.helper.data.network.places.PlacesRepository
import com.shop.helper.data.network.places.entities.Predictions
import com.shop.helper.data.network.places.entities.SearchCities
import com.shop.helper.domain.base.BaseInteractor
import com.shop.helper.utils.getLanguage
import retrofit2.Response

class SearchCityInteractor(private val repository: PlacesRepository) :
    BaseInteractor<String, Response<SearchCities>> {

    override suspend fun execute(query: String): Response<SearchCities> {
        val response = repository.searchCity(query, getLanguage(ShopHelperApplication.instance))
        if (response?.isSuccessful && response?.body()?.status() == GooglePlaceStatus.OK) {
            val predictions = response?.body()?.predictions ?: return response
            val result = arrayListOf<Predictions>()
            for (item in predictions) {
                for(type in item.types) {
                    if(type == "locality") {
                        result.add(item)
                    }
                }
            }
            response?.body()?.predictions = result
            return response
        } else {
            return response
        }
    }

}