package com.example.cleanarchitecturetryout.data.network

interface NetworkCallback {
    fun onSuccess(response: Any)
    fun onError(error: Throwable)
}