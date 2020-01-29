package com.shop.helper.presentation.auth

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.shop.helper.R
import com.shop.helper.presentation.base.BaseFragment

class AuthFragment : BaseFragment(), AuthView {

    private lateinit var textInputLayoutPhoneNumber: TextInputLayout
    private lateinit var textInputEditTextPhoneNumber: TextInputEditText
    private lateinit var buttonSignIn: Button
    private var presenter: AuthPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_auth, null)
        textInputLayoutPhoneNumber = view.findViewById(R.id.text_input_layout_phone_number)
        textInputEditTextPhoneNumber = view.findViewById(R.id.text_input_edit_text_phone_number)
        buttonSignIn = view.findViewById(R.id.button_sign_in)
        buttonSignIn.isEnabled = false
        val buttonSignUp: Button = view.findViewById(R.id.button_sign_up)
        buttonSignUp.setOnClickListener {
            presenter?.forwardToSignUp()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = AuthPresenter(this, activity as AuthActivity)
        textInputEditTextPhoneNumber.addTextChangedListener(textWatcherPhoneNumber)
    }

    override fun onResume() {
        super.onResume()
        getToolbar()?.visibility = View.GONE
    }

    private val textWatcherPhoneNumber = object : TextWatcher {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

        override fun afterTextChanged(text: Editable?) {
            val newText: String = text.toString()
            presenter?.checkPhoneNumberOnline(newText)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
    }

    override fun phoneNumberValidated() {
        textInputLayoutPhoneNumber.error = ""
        buttonSignIn.isEnabled = true
    }

    override fun phoneNumberNotValidated() {
        textInputLayoutPhoneNumber.error = getString(R.string.error_field_not_valid)
        buttonSignIn.isEnabled = false
    }

}