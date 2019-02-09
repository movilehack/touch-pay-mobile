package com.movile.touchpay.domain.datasource

import com.movile.touchpay.domain.model.SampleModel
import io.reactivex.Observable

interface ISampleLocalDataSource {
    fun getSampleDate(): Observable<SampleModel>
}