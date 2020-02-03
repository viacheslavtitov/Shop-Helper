package com.shop.helper.presentation.cities.add

import com.shop.helper.ShopHelperApplication
import com.shop.helper.data.network.places.PlacesRepository
import com.shop.helper.domain.cities.search.SearchCityInteractor
import com.shop.helper.presentation.base.BaseActivity
import com.shop.helper.presentation.base.BasePresenter
import com.shop.helper.data.network.base.provideRetrofit
import com.shop.helper.data.network.base.provideHttpUrl
import com.shop.helper.data.network.base.provideOkHttpClient
import com.shop.helper.data.network.base.provideGson
import com.shop.helper.utils.DISK_HTTP_CACHE_SIZE
import com.shop.helper.utils.GOOGLE_PLACES_BASE_API_URL
import com.shop.helper.utils.GOOGLE_PLACES_API_KEY
import okhttp3.HttpUrl

class AddNewCityPresenter(view: AddNewCityView, activity: BaseActivity) :
    BasePresenter<AddNewCityView, BaseActivity>() {

    private val searchCityInteractor: SearchCityInteractor

    init {
        attachView(view, activity)
        val gson = provideGson()
        val okHttpClient = provideOkHttpClient(ShopHelperApplication.instance, DISK_HTTP_CACHE_SIZE)
        val baseUrl = provideHttpUrl(GOOGLE_PLACES_BASE_API_URL)
        val retrofit = provideRetrofit(baseUrl, okHttpClient, gson)
        searchCityInteractor = SearchCityInteractor(PlacesRepository(retrofit, GOOGLE_PLACES_API_KEY))
    }

    fun searchCity(query: String) {
        searchCityInteractor.execute(query)
    }
}