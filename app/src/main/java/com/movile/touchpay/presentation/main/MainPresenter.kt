package com.movile.touchpay.presentation.main

import com.movile.touchpay.domain.usecase.samplemodel.SampleUseCase
import com.movile.touchpay.presentation.common.BasePresenter
import io.reactivex.disposables.Disposable

class MainPresenter(private val sampleUseCase: SampleUseCase) : BasePresenter<MainView>() {

    private fun loadContent() {
        val useCaseParam = SampleUseCase.SampleRequestValues("param")
        val observable = sampleUseCase.execute(useCaseParam).observable

        val disposable: Disposable = observable.subscribe(
            {
                view?.showSampleContent()
            },
            {
                view?.showError("Error: ${it.message}")
            })

        compositeDisposable.add(disposable)
    }

    fun performReceive() {
        view?.proceedToReceive()
    }

    override fun subscribe() {
        loadContent()
    }

    override fun unsubscribe() {
        compositeDisposable.clear()
    }
}