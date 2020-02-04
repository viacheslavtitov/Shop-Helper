package com.shop.helper.data.network.base.entities

abstract class BaseGooglePlace {

    abstract val status: String

    fun status() :GooglePlaceStatus {
        if(status.isNotEmpty()) {
            if(status == "OK") {
                return GooglePlaceStatus.OK
            } else if(status == "INVALID_REQUEST") {
                return GooglePlaceStatus.INVALID_REQUEST
            }
        }
        return GooglePlaceStatus.UNKNOWN
    }
}