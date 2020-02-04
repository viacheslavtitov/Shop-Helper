package com.shop.helper.domain.cities.search

import com.shop.helper.ShopHelperApplication
import com.shop.helper.data.network.places.PlacesRepository
import com.shop.helper.data.network.places.entities.SearchCities
import com.shop.helper.domain.base.BaseInteractor
import com.shop.helper.utils.getLanguage
import retrofit2.Response

class SearchCityInteractor(private val repository: PlacesRepository) :
    BaseInteractor<String, Response<SearchCities>> {

    override suspend fun execute(query: String): Response<SearchCities> {
        return repository.searchCity(query, getLanguage(ShopHelperApplication.instance))
    }

}