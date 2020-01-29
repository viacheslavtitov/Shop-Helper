package com.shop.helper.presentation.auth

import com.shop.helper.presentation.base.BasePresenter
import com.shop.helper.utils.isValidPhoneNumber

class AuthPresenter(view: AuthView, activity: AuthActivity) :
    BasePresenter<AuthView, AuthActivity>() {

    init {
        attachView(view, activity)
    }

    fun forwardToSignUp() {
        //TODO: forward user from auth to sign up screen
    }

    fun checkPhoneNumberOnline(inputNumber: String) {
        if(isValidPhoneNumber(inputNumber)) {
            view?.phoneNumberValidated()
        } else {
            view?.phoneNumberNotValidated()
        }
    }

}