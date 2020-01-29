package com.shop.helper.presentation.base

abstract class BasePresenter<V : BaseView, VV: BaseActivity> {

    protected var view: V? = null
    protected var activity: VV? = null

    open fun attachView(view: V, activity: VV) {
        this.view = view
        this.activity = activity
    }

    open fun detachView() {
        view = null
    }

}