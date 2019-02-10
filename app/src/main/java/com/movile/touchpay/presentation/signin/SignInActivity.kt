package com.movile.touchpay.presentation.signin

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.movile.touchpay.R
import com.movile.touchpay.presentation.common.BaseActivity
import com.movile.touchpay.presentation.main.MainActivity
import com.movile.touchpay.presentation.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.kodein.di.generic.instance

class SignInActivity : BaseActivity<SignInView>(), SignInView {

    override val layoutId: Int = R.layout.activity_sign_in

    override val presenter: SignInPresenter by instance()

    private lateinit var errorLabel: TextView
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var signInButton: Button
    private lateinit var signUpButton: Button

    override fun onCreate() {

        errorLabel = findViewById(R.id.lblError)
        emailInput = findViewById(R.id.edtxtEmail)
        passwordInput = findViewById(R.id.edtxtPassword)

        signInButton = findViewById(R.id.btnSignIn)
        signUpButton = findViewById(R.id.btnSignUp)

        signInButton.setOnClickListener { clickedSignInButton() }
        signUpButton.setOnClickListener { clickedSignUpButton() }
    }

    private fun clickedSignInButton() {
        errorLabel.visibility = View.INVISIBLE

        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()

        presenter.performSignIn(email, password)
    }

    private fun clickedSignUpButton() {
        errorLabel.visibility = View.INVISIBLE

        presenter.performSignUp()
    }

    override fun setPresenter() {
        presenter.attachView(this)
    }

    override fun showError(messageId: Int) {
        errorLabel.apply {
           text = getString(messageId)
           visibility = View.VISIBLE
       }
    }

    override fun showError(messsage: String) {
        errorLabel.apply {
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
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }

}
