package com.shop.helper.presentation.auth.registration

import com.shop.helper.presentation.auth.AuthActivity
import com.shop.helper.presentation.base.BasePresenter
import com.shop.helper.utils.isValidPhoneNumber

class SignUpPresenter(view: SignUpView, activity: AuthActivity) :
    BasePresenter<SignUpView, AuthActivity>() {

    init {
        attachView(view, activity)
    }

    fun forwardToValidation() {
    }

    fun checkPhoneNumberOnline(inputNumber: String) {
        if (isValidPhoneNumber(inputNumber)) {
            view?.phoneNumberValidated()
        } else {
            view?.phoneNumberNotValidated()
        }
    }

}