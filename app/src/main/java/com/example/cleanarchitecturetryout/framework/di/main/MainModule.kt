package com.example.cleanarchitecturetryout.framework.di.main

import com.example.cleanarchitecturetryout.data.main.MainRepository
import com.example.cleanarchitecturetryout.framework.source.main.MainApiService
import com.example.cleanarchitecturetryout.framework.source.main.MainSourceImpl
import com.example.cleanarchitecturetryout.interactor.main.CallSendOtpApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainModule {

    @MainScope
    @Provides
    fun provideCallSendOtpApi(mainRepository: MainRepository): CallSendOtpApi {
        return CallSendOtpApi(mainRepository)
    }

    @MainScope
    @Provides
    fun provideMainRepository(mainSourceImpl: MainSourceImpl): MainRepository {
        return MainRepository(mainSourceImpl)
    }

    @MainScope
    @Provides
    fun provideMainSourceImpl(apiService: MainApiService): MainSourceImpl {
        return MainSourceImpl(apiService)
    }

    @MainScope
    @Provides
    fun provideMainApiService(retrofit: Retrofit): MainApiService {
        return retrofit.create(MainApiService::class.java)
    }
}