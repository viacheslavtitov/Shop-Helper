package com.shop.helper.data.network.places

import com.shop.helper.data.network.places.entities.SearchCities
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class PlacesRepository @Inject constructor(retrofit: Retrofit, private val apiKey: String) {

    private val service: PlaceService = retrofit.create(PlaceService::class.java)

    fun searchCity(query: String, language: String): Response<SearchCities> {
        val options = mapOf("input" to query,
            "language" to language,
            "key" to apiKey,
            "types" to "(cities)",
            "components" to "country:ua",
            "fields" to "formatted_address,name,place_id,reference,id,geometry",
            "region" to "ua")
        return service.search(options).execute()
    }

}