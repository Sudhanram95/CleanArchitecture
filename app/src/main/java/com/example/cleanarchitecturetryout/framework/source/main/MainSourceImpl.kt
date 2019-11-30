package com.example.cleanarchitecturetryout.framework.source.main

import com.example.cleanarchitecturetryout.data.main.MainSource
import com.example.cleanarchitecturetryout.domain.main.MainRequest
import com.example.cleanarchitecturetryout.domain.main.MainResponse
import com.example.cleanarchitecturetryout.data.network.NetworkCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainSourceImpl @Inject constructor(val apiService: MainApiService) : MainSource {

    override fun callSendOtp(mainRequest: MainRequest, networkCallback: NetworkCallback) {
        apiService.sendOtp(mainRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<MainResponse>() {
                override fun onSuccess(response: MainResponse) {
                    networkCallback.onSuccess(response)
                }

                override fun onError(error: Throwable) {
                    networkCallback.onError(error)
                }
            })
    }
}