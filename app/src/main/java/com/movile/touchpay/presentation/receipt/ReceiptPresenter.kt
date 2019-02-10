package com.movile.touchpay.presentation.receipt

import com.movile.touchpay.presentation.common.BasePresenter

class ReceiptPresenter: BasePresenter<ReceiptView>() {

    fun performReceipt() {
        view?.proceedToHome()
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
    }

}