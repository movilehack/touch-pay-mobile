package com.movile.touchpay.domain.usecase.samplemodel

import com.movile.touchpay.domain.datasource.SampleDataSource
import com.movile.touchpay.domain.model.SampleModel
import com.movile.touchpay.domain.schedulers.BaseScheduler
import com.movile.touchpay.domain.usecase.BaseUseCase
import io.reactivex.Observable

class SampleUseCase(
    private val sampleRepository: SampleDataSource,
    private val schedulerProvider: BaseScheduler
) : BaseUseCase<SampleUseCase.SampleRequestValues, SampleUseCase.SampleResultValues>() {

    override fun execute(requestValues: SampleRequestValues): SampleResultValues {
        return SampleResultValues(
            sampleRepository.getSampleData()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
        )
    }

    class SampleRequestValues(val param: String) : RequestValues
    class SampleResultValues(val observable: Observable<SampleModel>) : ResultValues
}