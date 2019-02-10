package com.movile.touchpay.presentation.receipt

import android.content.Intent
import com.movile.touchpay.R
import com.movile.touchpay.presentation.common.BaseActivity
import com.movile.touchpay.presentation.main.MainActivity
import kotlinx.android.synthetic.main.activity_receipt.*
import org.kodein.di.generic.instance

class ReceiptActivity : BaseActivity<ReceiptView>(), ReceiptView {

    override val layoutId: Int = R.layout.activity_receipt
    override val presenter: ReceiptPresenter by instance()

    override fun onCreate() {

        btnReceipt.setOnClickListener { presenter.performReceipt() }
    }

    override fun setPresenter() {
        presenter.attachView(this)
    }

    override fun showError(messageId: Int) {
    }

    override fun showError(messsage: String) {
    }

    override fun proceedToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}
