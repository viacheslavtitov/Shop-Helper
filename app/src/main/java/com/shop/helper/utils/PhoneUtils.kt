package com.shop.helper.utils

import android.text.TextUtils
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber


private val UA_COUNTRY_CODE: String = "+380"

fun validatePhoneNumber(phone: String): PhoneNumber? {
    if (TextUtils.isEmpty(phone)) return null
    try {
        return PhoneNumberUtil.getInstance().parse(phone, "")
    } catch (e: NumberParseException) {

    }
    return null
}

fun isValidPhoneNumber(phoneNumber: String): Boolean {
    return isValidPhoneNumber(validatePhoneNumber(UA_COUNTRY_CODE.plus(phoneNumber?.trim())))
}

fun isValidPhoneNumber(phoneNumber: PhoneNumber?): Boolean {
    if (phoneNumber == null) return false
    val phoneUtil = PhoneNumberUtil.getInstance()
    val isValid = phoneUtil.isValidNumber(phoneNumber)
    return isValid
}
