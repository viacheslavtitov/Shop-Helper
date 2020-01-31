package com.shop.helper.presentation.cities

import com.shop.helper.R
import com.shop.helper.presentation.base.BaseActivity
import com.shop.helper.presentation.base.BasePresenter
import com.shop.helper.presentation.cities.add.AddNewCityFragment

class CitiesPresenter(view: CitiesView, activity: BaseActivity) :
    BasePresenter<CitiesView, BaseActivity>() {

    init {
        attachView(view, activity)
    }

    fun forwardToAddNewCity() {
        val fragment = AddNewCityFragment()
        activity?.replaceFragment(R.id.frame_container, fragment.tag, fragment)
    }
}