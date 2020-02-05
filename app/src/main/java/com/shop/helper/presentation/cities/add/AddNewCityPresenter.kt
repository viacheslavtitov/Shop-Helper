package com.shop.helper.presentation.cities.add

import com.shop.helper.R
import com.shop.helper.data.network.base.entities.GooglePlaceStatus
import com.shop.helper.domain.cities.search.SearchCityInteractor
import com.shop.helper.presentation.base.BaseActivity
import com.shop.helper.presentation.base.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddNewCityPresenter @Inject constructor(private val searchCityInteractor: SearchCityInteractor) :
    BasePresenter<AddNewCityView, BaseActivity>() {

    fun searchCity(query: String) {
        view?.showProgress()
        CoroutineScope(Dispatchers.IO).launch {
            val response = searchCityInteractor.execute(query)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    when (response.body()?.status()) {
                        GooglePlaceStatus.OK -> {
                            view?.displayCities(response.body()?.predictions)
                        }
                        GooglePlaceStatus.INVALID_REQUEST -> {
                            view?.showMessage(R.string.error_invalid_request)
                        }
                    }
                }
                view?.hideProgress()
            }
        }
    }
}