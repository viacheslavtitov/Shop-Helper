package com.shop.helper.data.network.base.entities

abstract class BaseGooglePlace {

    abstract val status: String

    fun isSuccessful(): Boolean {
        return status.isNotEmpty() && status == "OK"
    }
}