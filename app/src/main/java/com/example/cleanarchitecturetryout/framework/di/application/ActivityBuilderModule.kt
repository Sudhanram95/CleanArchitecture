package com.example.cleanarchitecturetryout.framework.di.application

import com.example.cleanarchitecturetryout.framework.di.ecommerce.EcommerceFragmentBuilderModule
import com.example.cleanarchitecturetryout.framework.di.ecommerce.EcommerceModule
import com.example.cleanarchitecturetryout.framework.di.ecommerce.EcommerceScope
import com.example.cleanarchitecturetryout.framework.di.ecommerce.EcommerceViewModelModule
import com.example.cleanarchitecturetryout.framework.di.main.MainModule
import com.example.cleanarchitecturetryout.framework.di.main.MainScope
import com.example.cleanarchitecturetryout.framework.di.main.MainViewModelModule
import com.example.cleanarchitecturetryout.ui.ecommerce.view.EcommerceActivity
import com.example.cleanarchitecturetryout.ui.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @MainScope
    @ContributesAndroidInjector(modules = [MainViewModelModule::class, MainModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @EcommerceScope
    @ContributesAndroidInjector(modules = [EcommerceFragmentBuilderModule::class, EcommerceModule::class, EcommerceViewModelModule::class])
    abstract fun contributeEcommerceActivity(): EcommerceActivity
}