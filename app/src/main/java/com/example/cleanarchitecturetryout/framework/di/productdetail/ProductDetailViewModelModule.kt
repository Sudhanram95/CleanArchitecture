package com.example.cleanarchitecturetryout.framework.di.productdetail

import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturetryout.framework.di.viewmodel.ViewModelKey
import com.example.cleanarchitecturetryout.ui.ecommerce.productdetail.viewmodel.ProductDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProductDetailViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailViewModel::class)
    protected abstract fun productDetailViewModel(productDetailViewModel: ProductDetailViewModel): ViewModel
}