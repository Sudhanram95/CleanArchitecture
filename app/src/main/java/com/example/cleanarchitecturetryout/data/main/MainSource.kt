package com.example.cleanarchitecturetryout.data.main

import com.example.cleanarchitecturetryout.data.network.NetworkCallback
import com.example.cleanarchitecturetryout.domain.main.MainRequest

interface MainSource {
    fun callSendOtp(mainRequest: MainRequest, networkCallback: NetworkCallback)
}