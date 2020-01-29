package com.shop.helper.presentation.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.shop.helper.R
import com.shop.helper.presentation.base.BaseFragment

class AuthFragment : BaseFragment() {

    private lateinit var textInputLayoutPhoneNumber: TextInputLayout
    private lateinit var textInputEditTextPhoneNumber: TextInputEditText
    private lateinit var buttonSignIn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_auth, null)
        textInputLayoutPhoneNumber = view.findViewById(R.id.text_input_layout_phone_number)
        textInputEditTextPhoneNumber = view.findViewById(R.id.text_input_edit_text_phone_number)
        buttonSignIn = view.findViewById(R.id.button_sign_in)
        val buttonSignUp: Button = view.findViewById(R.id.button_sign_up)
        buttonSignUp.setOnClickListener {
            forwardSignUp()
        }
        return view
    }

    private fun forwardSignUp() {

    }

}