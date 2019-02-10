package com.movile.touchpay.presentation.signin

import com.movile.touchpay.presentation.common.BasePresenter

class SignInPresenter: BasePresenter<SignInView>() {

    fun performSignIn(email: String, password: String) {

    }

    fun performSignUp() {
        view?.proceedToSignUp()
    }

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}