package com.movile.touchpay.di

import com.movile.touchpay.domain.schedulers.BaseScheduler
import com.movile.touchpay.domain.schedulers.SchedulerProvider
import com.movile.touchpay.domain.usecase.samplemodel.SampleUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val useCaseModule = Kodein.Module("use_case_module") {

    bind<SampleUseCase>() with provider { SampleUseCase(instance(), instance()) }
}

val schedulersModule = Kodein.Module("schedulers_module") {

    bind<BaseScheduler>() with provider { SchedulerProvider() }
}