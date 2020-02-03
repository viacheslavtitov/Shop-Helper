package com.shop.helper.presentation.auth

import com.shop.helper.R
import com.shop.helper.presentation.auth.registration.SignUpFragment
import com.shop.helper.presentation.base.BasePresenter
import com.shop.helper.utils.isValidPhoneNumber

class AuthPresenter(view: AuthView, activity: AuthActivity) :
    BasePresenter<AuthView, AuthActivity>() {

    init {
        attachView(view, activity)
    }

    fun forwardToSignUp() {
        val fragment = SignUpFragment()
        activity?.replaceFragment(R.id.frame_container, fragment.tag, fragment)
    }

    fun checkPhoneNumberOnline(inputNumber: String) {
        if(isValidPhoneNumber(inputNumber)) {
            view?.phoneNumberValidated()
        } else {
            view?.phoneNumberNotValidated()
        }
    }

}