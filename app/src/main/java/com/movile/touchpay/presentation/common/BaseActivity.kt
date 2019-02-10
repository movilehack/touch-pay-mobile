package com.movile.touchpay.presentation.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.KodeinAware

abstract class BaseActivity<V : BaseView> : AppCompatActivity(), BaseView, KodeinAware {

    override val kodein by org.kodein.di.android.kodein()


    protected abstract val layoutId: Int
    protected abstract val presenter: BasePresenter<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        setPresenter()
        onCreate()
    }

    protected abstract fun onCreate()

    protected abstract fun setPresenter()

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }

}