package com.example.cleanarchitecturetryout.framework.di.ecommerce

import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturetryout.framework.di.viewmodel.ViewModelKey
import com.example.cleanarchitecturetryout.ui.ecommerce.viewmodel.EcommerceViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class EcommerceViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(EcommerceViewModel::class)
    protected abstract fun ecommerceViewModel(ecommerceViewModel: EcommerceViewModel): ViewModel
}