package com.shop.helper.utils

import android.content.Context
import com.shop.helper.R

const val DISK_HTTP_CACHE_SIZE: Long = 50 * 1024 * 1024 * 8
const val GOOGLE_PLACES_BASE_API_URL = "https://maps.googleapis.com/maps/api/place/"
const val GOOGLE_PLACES_API_KEY = "AIzaSyAAd06XZT84CiukbzMmeuVh_XNU5U7sEfc"

fun getLanguage(context: Context): String {
    return context.getString(R.string.language)
}