package com.movile.touchpay.presentation.receive

import com.movile.touchpay.presentation.common.BaseView

interface ReceiveView: BaseView {
    fun nextStep()
    fun proceedToReceipt()
}