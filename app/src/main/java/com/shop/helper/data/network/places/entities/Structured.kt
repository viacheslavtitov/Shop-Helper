package com.shop.helper.data.network.places.entities

import com.google.gson.annotations.SerializedName

data class Structured(
    @SerializedName("main_text") var mainText: String,
    @SerializedName("secondary_text") var secondaryText: String
)