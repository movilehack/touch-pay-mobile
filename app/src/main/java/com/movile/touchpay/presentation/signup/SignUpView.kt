package com.movile.touchpay.presentation.signup

import com.movile.touchpay.presentation.common.BaseView

interface SignUpView: BaseView {
    fun nextStep()
    fun proceedToMain()
}