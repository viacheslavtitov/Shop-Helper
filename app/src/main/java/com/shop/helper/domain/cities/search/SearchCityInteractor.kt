package com.shop.helper.domain.cities.search

import com.shop.helper.ShopHelperApplication
import com.shop.helper.data.network.places.PlacesRepository
import com.shop.helper.domain.base.BaseInteractor
import com.shop.helper.utils.getLanguage
import retrofit2.Call
import retrofit2.Response

class SearchCityInteractor(private val repository: PlacesRepository) : BaseInteractor<String, Response<Any>> {

    override suspend fun execute(query: String): Response<Any> {
        return repository.searchCity(query, getLanguage(ShopHelperApplication.instance))
    }

}