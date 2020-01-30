package com.shop.helper.presentation.auth.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.shop.helper.R
import com.shop.helper.presentation.base.BaseFragment

class SignUpFragment : BaseFragment(), SignUpView {

    private lateinit var textInputLayoutPhoneNumber: TextInputLayout
    private lateinit var textInputEditTextPhoneNumber: TextInputEditText
    private lateinit var textInputLayoutFirstName: TextInputLayout
    private lateinit var textInputEditTextFirstName: TextInputEditText
    private lateinit var textInputLayoutSecondName: TextInputLayout
    private lateinit var textInputEditTextSecondName: TextInputEditText
    private lateinit var buttonChooseCity: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_sign_up, null)
        textInputLayoutPhoneNumber = view.findViewById(R.id.text_input_layout_phone_number)
        textInputEditTextPhoneNumber = view.findViewById(R.id.text_input_edit_text_phone_number)

        textInputLayoutFirstName = view.findViewById(R.id.text_input_layout_first_name)
        textInputEditTextFirstName = view.findViewById(R.id.text_input_edit_text_first_name)

        textInputLayoutSecondName = view.findViewById(R.id.text_input_layout_second_name)
        textInputEditTextSecondName = view.findViewById(R.id.text_input_edit_text_second_name)

        buttonChooseCity = view.findViewById(R.id.button_choose_city)
        val buttonSignUp: Button = view.findViewById(R.id.button_sign_up)
        buttonSignUp.setOnClickListener {

        }
        buttonChooseCity.setOnClickListener {

        }
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onResume() {
        super.onResume()
        getToolbar()?.title = getString(R.string.title_sign_up)
        getToolbar()?.visibility = View.VISIBLE
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            getToolbar()?.visibility = View.GONE
            activity?.supportFragmentManager?.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

}