package com.movile.touchpay.presentation.receive

import com.movile.touchpay.presentation.common.BasePresenter

class ReceivePresenter: BasePresenter<ReceiveView>() {

    fun performReceive() {
        view?.proceedToReceipt()
    }
    override fun subscribe() {
    }

    override fun unsubscribe() {
    }

}