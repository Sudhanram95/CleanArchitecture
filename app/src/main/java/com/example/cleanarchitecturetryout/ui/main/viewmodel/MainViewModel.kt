package com.example.cleanarchitecturetryout.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturetryout.domain.main.MainRequest
import com.example.cleanarchitecturetryout.domain.main.MainResponse
import com.example.cleanarchitecturetryout.data.network.NetworkCallback
import com.example.cleanarchitecturetryout.data.network.Resource
import com.example.cleanarchitecturetryout.interactor.main.CallSendOtpApi
import javax.inject.Inject

class MainViewModel @Inject constructor(val callSendOtpApi: CallSendOtpApi) : ViewModel() {

    val mainResponseLiveData = MutableLiveData<Resource<MainResponse>>()

    fun observeResponse() = mainResponseLiveData

    fun callSendOtp(request: MainRequest) {
        mainResponseLiveData.value = Resource.loading(null)
        callSendOtpApi(request, object : NetworkCallback {
            override fun onSuccess(response: Any) {
                mainResponseLiveData.value = Resource.success(response as MainResponse)
            }

            override fun onError(error: Throwable) {
                mainResponseLiveData.value = Resource.error(error, null)
            }
        })
    }

}