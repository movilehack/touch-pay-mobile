package com.movile.touchpay.presentation.signin

import android.content.Intent
import android.view.View
import com.movile.touchpay.R
import com.movile.touchpay.presentation.common.BaseActivity
import com.movile.touchpay.presentation.main.MainActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.kodein.di.generic.instance

class SignInActivity : BaseActivity<SignInView>(), SignInView {

    override val layoutId: Int = R.layout.activity_sign_in

    override val presenter: SignInPresenter by instance()

    override fun onCreate() {

        btnSignIn.setOnClickListener { clickedSignInButton() }
        btnSignUp.setOnClickListener { clickedSignUpButton() }
    }

    private fun clickedSignInButton() {
        lblError.visibility = View.INVISIBLE

        val email = edtxtEmail.text.toString()
        val password = edtxtPassword.text.toString()

        presenter.performSignIn(email, password)
    }

    private fun clickedSignUpButton() {
        lblError.visibility = View.INVISIBLE
    }

    override fun setPresenter() {
        presenter.attachView(this)
    }

    override fun showError(messageId: Int) {
       lblError.apply {
           text = getString(messageId)
           visibility = View.VISIBLE
       }
    }

    override fun showError(messsage: String) {
        lblError.apply {
            text = messsage
            visibility = View.VISIBLE
        }
    }

    override fun proceedToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun proceedToSignUp() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
