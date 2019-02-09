package com.movile.touchpay.presentation.common

import androidx.annotation.StringRes

interface BaseView {
    fun showError(@StringRes messageId: Int)
    fun showError(messsage: String)
}