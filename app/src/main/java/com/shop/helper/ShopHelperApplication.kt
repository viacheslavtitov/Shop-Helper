package com.shop.helper

import android.app.Application
import timber.log.Timber

class ShopHelperApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}