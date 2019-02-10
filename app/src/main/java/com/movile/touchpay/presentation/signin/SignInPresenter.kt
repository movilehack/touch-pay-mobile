package com.movile.touchpay.presentation.signin

import com.movile.touchpay.presentation.common.BasePresenter

class SignInPresenter: BasePresenter<SignInView>() {

    fun performSignIn(email: String, password: String) {
        view?.proceedToMain()
    }

    fun performSignUp() {
        view?.proceedToSignUp()
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
    }
}