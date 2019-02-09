package com.movile.touchpay.data.source.remote

import com.movile.touchpay.data.source.remote.network.ApiClient
import com.movile.touchpay.domain.datasource.ISampleRemoteDataSource
import com.movile.touchpay.domain.model.SampleModel
import io.reactivex.Observable

class SampleRemoteDataSource(private val apiClient: ApiClient) : ISampleRemoteDataSource {
    override fun fetchSampleData(): Observable<SampleModel> {
        return apiClient.sampleData().map { SampleModel("sample") }
    }

}