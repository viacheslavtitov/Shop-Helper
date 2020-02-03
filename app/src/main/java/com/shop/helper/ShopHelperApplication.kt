package com.shop.helper

import android.app.Application
import timber.log.Timber

class ShopHelperApplication : Application() {

    companion object {
        lateinit var instance: ShopHelperApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}