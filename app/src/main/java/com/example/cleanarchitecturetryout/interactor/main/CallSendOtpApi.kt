package com.example.cleanarchitecturetryout.interactor.main

import com.example.cleanarchitecturetryout.data.main.MainRepository
import com.example.cleanarchitecturetryout.data.network.NetworkCallback
import com.example.cleanarchitecturetryout.domain.main.MainRequest

class CallSendOtpApi(val mainRepository: MainRepository) {

    operator fun invoke(mainRequest: MainRequest, networkCallback: NetworkCallback) {
        mainRepository.callSendOtpApi(mainRequest, networkCallback)
    }
}