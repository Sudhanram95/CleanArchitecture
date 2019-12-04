package com.example.cleanarchitecturetryout.framework.di.categorylist

import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturetryout.framework.di.viewmodel.ViewModelKey
import com.example.cleanarchitecturetryout.ui.ecommerce.categorylist.viewmodel.CategoryListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CategoryListViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CategoryListViewModel::class)
    protected abstract fun categoryListViewModel(categoryListViewModel: CategoryListViewModel): ViewModel
}