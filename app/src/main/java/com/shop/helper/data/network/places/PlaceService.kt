package com.shop.helper.data.network.places

import com.shop.helper.data.network.places.entities.SearchCities
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface PlaceService {

    //https://maps.googleapis.com/maps/api/place/autocomplete/json?input=krem&types=(cities)&language=en&components=country:ua&fields=formatted_address,name,place_id,reference,id,geometry&region=ua&key=AIzaSyAAd06XZT84CiukbzMmeuVh_XNU5U7sEfc
    @GET("autocomplete/json")
    fun search(@QueryMap options: Map<String, String>): Call<SearchCities>

}