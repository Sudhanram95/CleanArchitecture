package com.example.cleanarchitecturetryout.framework.di.cart

import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturetryout.framework.di.viewmodel.ViewModelKey
import com.example.cleanarchitecturetryout.ui.ecommerce.cart.viewmodel.CartViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CartViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    protected abstract fun cartViewModel(cartViewModel: CartViewModel): ViewModel
}