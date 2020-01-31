package com.shop.helper.presentation.cities

import com.shop.helper.presentation.base.BaseActivity
import com.shop.helper.presentation.base.BasePresenter

class CitiesPresenter(view: CitiesView, activity: BaseActivity) :
    BasePresenter<CitiesView, BaseActivity>() {

    init {
        attachView(view, activity)
    }
}