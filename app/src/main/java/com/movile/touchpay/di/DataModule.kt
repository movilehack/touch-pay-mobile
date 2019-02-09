package com.movile.touchpay.di

import com.movile.touchpay.data.repository.SampleRepository
import com.movile.touchpay.data.source.local.SampleLocalDataSource
import com.movile.touchpay.data.source.remote.SampleRemoteDataSource
import com.movile.touchpay.data.source.remote.network.ApiClient
import com.movile.touchpay.data.source.remote.network.ServiceClient
import com.movile.touchpay.domain.datasource.ISampleLocalDataSource
import com.movile.touchpay.domain.datasource.ISampleRemoteDataSource
import com.movile.touchpay.domain.datasource.SampleDataSource
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val networkModule = Kodein.Module("network_module") {

    bind<ApiClient>() with singleton { ServiceClient().getApiClient() }
}

val dataSourceModule = Kodein.Module("data_source_module") {

    bind<SampleDataSource>() with singleton { SampleRepository(instance(), instance()) }

    bind<ISampleLocalDataSource>() with singleton { SampleLocalDataSource() }

    bind<ISampleRemoteDataSource>() with singleton { SampleRemoteDataSource(instance()) }
}