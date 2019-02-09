package com.movile.touchpay.presentation

import android.app.Application
import com.movile.touchpay.di.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class TouchPayApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@TouchPayApplication))
        import(networkModule)
        import(dataSourceModule)
        import(schedulersModule)
        import(useCaseModule)
        import(presenterModule)
    }
}