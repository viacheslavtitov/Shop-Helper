package com.shop.helper.presentation.base.di

import android.content.Context
import com.shop.helper.ShopHelperApplication
import com.shop.helper.presentation.auth.AuthActivity
import com.shop.helper.presentation.cities.add.AddNewCityFragment
import com.shop.helper.presentation.cities.add.di.AddNewCityModule
import dagger.BindsInstance
import dagger.Component


@Component(modules = [AddNewCityModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(activity: AuthActivity)

    fun inject(fragment: AddNewCityFragment)

}