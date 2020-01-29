package com.shop.helper.presentation.base

import android.app.Dialog
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.shop.helper.R


abstract class BaseActivity : AppCompatActivity(), BaseView {

    private var toast: Toast? = null
    private var progressDialog: Dialog? = null
    protected lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun showMessage(message: String) {
        toast?.cancel()
        toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast?.show()
    }

    override fun showMessage(stringResId: Int) {
        val message = resources?.getString(stringResId)
        if (message != null) showMessage(message)
    }

    override fun showMessage(message: String, vararg args: Any) {
        val formatMessage = String.format(message, *args)
        showMessage(formatMessage)
    }

    override fun showMessage(stringResId: Int, vararg args: Any) {
        val message = resources?.getString(stringResId)
        if (message != null) showMessage(message, args)
    }

    override fun showProgress() {
        runOnUiThread {
            if (progressDialog == null) {
                progressDialog = getProgressDialog()
            }
            if (progressDialog?.isShowing == true) progressDialog?.hide()
            progressDialog?.show()
        }
    }

    override fun hideProgress() {
        runOnUiThread {
            if (!isFinishing) {
                progressDialog?.hide()
            }
            progressDialog?.dismiss()
            progressDialog = null
        }
    }

    override fun showError(throwable: Throwable) {
        val message: String? = throwable.message
        if (message != null) showMessage(message)
    }

    private fun getProgressDialog(): Dialog? {
        val view: View =
            LayoutInflater.from(this).inflate(R.layout.layout_progress_dialog, null)
        val messageView: TextView = view.findViewById(R.id.message)
        messageView.setText(R.string.message_loading)
        val alertDialog: AlertDialog = AlertDialog.Builder(this)
            .setCancelable(false)
            .setView(view)
            .create()
        val pb = view.findViewById<View>(R.id.progressBar) as ProgressBar
        pb.indeterminateDrawable
            .setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY)
        alertDialog.window?.setBackgroundDrawable(
            ColorDrawable(Color.TRANSPARENT)
        )
        return alertDialog
    }

    protected fun replaceFragment(containerId: Int, fragment: BaseFragment) {
        supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }
}