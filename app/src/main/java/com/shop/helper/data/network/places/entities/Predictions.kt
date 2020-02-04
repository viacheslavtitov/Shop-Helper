package com.shop.helper.data.network.places.entities

import com.google.gson.annotations.SerializedName

data class Predictions(
    @SerializedName("description") val description: String,
    @SerializedName("id") val id: String,
    @SerializedName("place_id") val placeId: String,
    @SerializedName("reference") val reference: String,
    @SerializedName("structured_formatting") val structured: Structured,
    @SerializedName("types") val types: Array<String>
) {
    fun getPrimaryName(): String {
        return structured?.mainText
    }

    fun getSecondName(): String {
        return structured?.secondaryText
    }
}