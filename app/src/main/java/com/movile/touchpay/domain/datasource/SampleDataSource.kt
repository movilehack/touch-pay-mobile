package com.movile.touchpay.domain.datasource

import com.movile.touchpay.domain.model.SampleModel
import io.reactivex.Observable

interface SampleDataSource {
    fun getSampleData(): Observable<SampleModel>
}