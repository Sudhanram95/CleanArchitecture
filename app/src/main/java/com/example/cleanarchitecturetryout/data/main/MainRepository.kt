package com.example.cleanarchitecturetryout.data.main

import com.example.cleanarchitecturetryout.data.network.NetworkCallback
import com.example.cleanarchitecturetryout.domain.main.MainRequest

class MainRepository(val mainSource: MainSource) {

    fun callSendOtpApi(request: MainRequest, networkCallback: NetworkCallback) {
        mainSource.callSendOtp(request, networkCallback)
    }
}