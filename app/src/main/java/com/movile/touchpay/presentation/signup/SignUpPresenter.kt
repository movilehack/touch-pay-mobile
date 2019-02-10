package com.movile.touchpay.presentation.signup

import com.movile.touchpay.presentation.common.BasePresenter

class SignUpPresenter: BasePresenter<SignUpView>() {

    fun performSignUp() {
        view?.proceedToMain()
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
    }
}