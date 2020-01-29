package com.shop.helper.presentation.auth

import android.os.Bundle
import android.view.WindowManager
import com.shop.helper.R
import com.shop.helper.presentation.base.BaseActivity

class AuthActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        replaceFragment(R.id.frame_container, AuthFragment())
    }

}