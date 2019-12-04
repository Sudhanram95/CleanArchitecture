package com.example.cleanarchitecturetryout.framework.di.productlist

import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturetryout.framework.di.viewmodel.ViewModelKey
import com.example.cleanarchitecturetryout.ui.ecommerce.productlist.viewmodel.ProductListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProductListViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProductListViewModel::class)
    protected abstract fun productListViewModel(productListViewModel: ProductListViewModel): ViewModel
}