package com.example.cleanarchitecturetryout.data.network

class Resource<T>(var status: Status, var data: T?, var error: Throwable?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun<T> success(data: T): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data!!,
                null
            )
        }

        fun<T> error(error: Throwable?, data: T?): Resource<T> {
            return Resource<T>(
                Status.ERROR,
                data,
                error
            )
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource<T>(
                Status.LOADING,
                data,
                null
            )
        }
    }
}