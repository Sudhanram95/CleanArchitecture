package com.example.cleanarchitecturetryout.domain.main

import com.google.gson.annotations.SerializedName

class MainRequest {

    @SerializedName("phone_number")
    lateinit var mobileNumber: String
}