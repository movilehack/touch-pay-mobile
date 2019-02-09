package com.movile.touchpay.data.source.local

import com.movile.touchpay.domain.datasource.ISampleLocalDataSource
import com.movile.touchpay.domain.model.SampleModel
import io.reactivex.Observable

class SampleLocalDataSource : ISampleLocalDataSource {
    override fun getSampleDate(): Observable<SampleModel> {
        return Observable.fromPublisher { SampleModel("Sample") }
    }

}