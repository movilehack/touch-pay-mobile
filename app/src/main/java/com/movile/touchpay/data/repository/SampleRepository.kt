package com.movile.touchpay.data.repository

import com.movile.touchpay.domain.datasource.ISampleLocalDataSource
import com.movile.touchpay.domain.datasource.ISampleRemoteDataSource
import com.movile.touchpay.domain.datasource.SampleDataSource
import com.movile.touchpay.domain.model.SampleModel
import io.reactivex.Observable

class SampleRepository(
    private val remoteDataSource: ISampleRemoteDataSource,
    private val localDataSource: ISampleLocalDataSource
) : SampleDataSource {

    override fun getSampleData(): Observable<SampleModel> {
        return Observable.concat(remoteDataSource.fetchSampleData(), localDataSource.getSampleDate())
    }
}