package com.example.cleanarchitecturetryout.framework.source.main

import com.example.cleanarchitecturetryout.domain.main.MainRequest
import com.example.cleanarchitecturetryout.domain.main.MainResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface MainApiService {
    @POST("/v1/sendotp")
    fun sendOtp(@Body request: MainRequest): Single<MainResponse>
}