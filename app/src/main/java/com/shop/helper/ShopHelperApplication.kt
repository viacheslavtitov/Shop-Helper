package com.shop.helper

import android.app.Application
import com.shop.helper.presentation.base.di.ApplicationComponent
import com.shop.helper.presentation.base.di.DaggerApplicationComponent
import timber.log.Timber

class ShopHelperApplication : Application() {

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }

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