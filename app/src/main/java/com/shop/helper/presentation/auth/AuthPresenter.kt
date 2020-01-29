package com.shop.helper.presentation.auth

import com.shop.helper.presentation.base.BasePresenter

class AuthPresenter(view: AuthView, activity: AuthActivity) :
    BasePresenter<AuthView, AuthActivity>() {

    init {
        attachView(view, activity)
    }

    fun forwardToSignUp() {
        //TODO: forward user from auth to sign up screen
    }

}