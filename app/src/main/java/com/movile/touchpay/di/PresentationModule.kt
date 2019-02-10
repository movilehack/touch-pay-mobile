package com.movile.touchpay.di

import com.movile.touchpay.presentation.main.MainPresenter
import com.movile.touchpay.presentation.receipt.ReceiptPresenter
import com.movile.touchpay.presentation.receive.ReceivePresenter
import com.movile.touchpay.presentation.signin.SignInPresenter
import com.movile.touchpay.presentation.signup.SignUpPresenter
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val presenterModule = Kodein.Module("presenter_module") {
    bind<MainPresenter>() with provider { MainPresenter(instance()) }
    bind<SignInPresenter>() with provider { SignInPresenter() }
    bind<SignUpPresenter>() with provider { SignUpPresenter() }
    bind<ReceivePresenter>() with provider { ReceivePresenter() }
    bind<ReceiptPresenter>() with provider { ReceiptPresenter() }
}