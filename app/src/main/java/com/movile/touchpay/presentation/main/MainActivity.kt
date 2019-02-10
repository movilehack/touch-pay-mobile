package com.movile.touchpay.presentation.main

import android.content.Intent
import android.util.Log
import android.widget.FrameLayout
import android.widget.Toast
import com.movile.touchpay.R
import com.movile.touchpay.presentation.common.BaseActivity
import com.movile.touchpay.presentation.receipt.ReceiptActivity
import com.movile.touchpay.presentation.receive.ReceiveActivity
import org.kodein.di.generic.instance

class MainActivity : BaseActivity<MainView>(), MainView {

    override val layoutId: Int = R.layout.activity_main
    override val presenter: MainPresenter by instance()

    private lateinit var receiveButton: FrameLayout

    override fun onCreate() {

        receiveButton = findViewById(R.id.receiveFrame)
        receiveButton.setOnClickListener { presenter.performReceive() }
    }

    override fun setPresenter() {
        presenter.attachView(this)
    }

    override fun showSampleContent() {
        Log.d("XABLAU", "Sample Content")
    }

    override fun proceedToReceive() {
        val intent = Intent(this, ReceiveActivity::class.java)
        startActivity(intent)
    }

    override fun showError(messageId: Int) {
        Log.e("XABLAU", "Sample Error")
    }

    override fun showError(messsage: String) {
        Log.e("XABLAU", messsage)
    }

}
