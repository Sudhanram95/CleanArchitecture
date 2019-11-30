package com.example.cleanarchitecturetryout.framework.di.application

import android.app.Application
import com.example.cleanarchitecturetryout.framework.network.NetworkModule
import com.example.cleanarchitecturetryout.framework.di.viewmodel.FactoryModule
import com.example.cleanarchitecturetryout.ui.TryoutApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
                        ActivityBuilderModule::class,
                        NetworkModule::class,
                        FactoryModule::class])
interface ApplicationComponent: AndroidInjector<TryoutApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}