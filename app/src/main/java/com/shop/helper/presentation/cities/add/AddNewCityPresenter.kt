package com.shop.helper.presentation.cities.add

import com.shop.helper.presentation.base.BaseActivity
import com.shop.helper.presentation.base.BasePresenter

class AddNewCityPresenter(view: AddNewCityView, activity: BaseActivity) :
    BasePresenter<AddNewCityView, BaseActivity>() {

    init {
        attachView(view, activity)
    }
}