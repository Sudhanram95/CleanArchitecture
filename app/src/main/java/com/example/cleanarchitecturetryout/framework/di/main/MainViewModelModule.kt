package com.example.cleanarchitecturetryout.framework.di.main

import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturetryout.framework.di.viewmodel.ViewModelKey
import com.example.cleanarchitecturetryout.ui.main.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    protected abstract fun sendOtpViewModel(mainViewModel: MainViewModel): ViewModel
}