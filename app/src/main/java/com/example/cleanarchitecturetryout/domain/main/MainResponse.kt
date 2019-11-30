package com.example.cleanarchitecturetryout.domain.main

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MainResponse {

    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("httpCode")
    @Expose
    var httpCode: Int = 0
}