package com.shop.helper.data.network.places.entities

import com.google.gson.annotations.SerializedName
import com.shop.helper.data.network.base.entities.BaseGooglePlace

data class SearchCities(@SerializedName("predictions") var predictions : List<Predictions>,
                        @SerializedName("status") override val status: String)
    : BaseGooglePlace()