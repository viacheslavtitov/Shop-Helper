package com.shop.helper.data.network.places

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

class PlacesRepository(retrofit: Retrofit, private val apiKey: String) {

    private val service: PlaceService = retrofit.create(PlaceService::class.java)

    fun searchCity(query: String, language: String): Response<Any> {
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