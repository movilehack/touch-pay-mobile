package com.movile.touchpay.di

import com.movile.touchpay.presentation.main.MainPresenter
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val presenterModule = Kodein.Module("presenter_module") {
    bind<MainPresenter>() with provider { MainPresenter(instance()) }
}