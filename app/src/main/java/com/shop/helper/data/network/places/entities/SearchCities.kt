package com.shop.helper.data.network.places.entities

import com.google.gson.annotations.SerializedName

data class SearchCities (
    @SerializedName("predictions") val predictions : List<Predictions>,
    @SerializedName("status") val status : String
)