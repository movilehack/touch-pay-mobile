package com.movile.touchpay.presentation.main

import android.util.Log
import com.movile.touchpay.R
import com.movile.touchpay.presentation.common.BaseActivity
import org.kodein.di.generic.instance

class MainActivity : BaseActivity<MainView>(), MainView {

    override val layoutId: Int = R.layout.activity_main
    override val presenter: MainPresenter by instance()

    override fun setPresenter() {
        presenter.attachView(this)
    }

    override fun showSampleContent() {
        Log.d("XABLAU", "Sample Content")
    }

    override fun showError(messageId: Int) {
        Log.e("XABLAU", "Sample Error")
    }

    override fun showError(messsage: String) {
        Log.e("XABLAU", messsage)
    }

}
