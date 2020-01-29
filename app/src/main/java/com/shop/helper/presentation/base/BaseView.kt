package com.shop.helper.presentation.base

interface BaseView {

    fun showProgress()

    fun hideProgress()

    fun showMessage(message: String)

    fun showMessage(message: String, vararg args: Any)

    fun showMessage(stringResId: Int)

    fun showMessage(stringResId: Int, vararg args: Any)

    fun showError(throwable: Throwable)

}