package com.movile.touchpay.presentation.signin

import com.movile.touchpay.presentation.common.BaseView

interface SignInView: BaseView {
    fun proceedToMain()
    fun proceedToSignUp()
}