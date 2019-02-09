package com.movile.touchpay.data.source.remote.network

import com.movile.touchpay.data.source.remote.model.ResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiClient {
    companion object {
        const val API_KEY = "auihsauhsa21"
        const val API_VERSION = "v2000"
        const val DEFAULT_LANGUAGE = "pt-BR"
    }

    @GET("sample/data")
    fun sampleData(): Observable<ResponseModel>
}