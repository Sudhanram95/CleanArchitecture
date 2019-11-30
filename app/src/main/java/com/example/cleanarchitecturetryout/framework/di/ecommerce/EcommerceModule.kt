package com.example.cleanarchitecturetryout.framework.di.ecommerce

import com.example.cleanarchitecturetryout.data.ecommerce.EcommerceRepository
import com.example.cleanarchitecturetryout.data.ecommerce.EcommerceSource
import com.example.cleanarchitecturetryout.framework.source.ecommerce.EcommerceSourceImpl
import com.example.cleanarchitecturetryout.interactor.ecommerce.GetAllProducts
import com.example.cleanarchitecturetryout.ui.TryoutApplication
import dagger.Module
import dagger.Provides

@Module
class EcommerceModule {

    @EcommerceScope
    @Provides
    fun provideGetAllProducts(ecommerceRepository: EcommerceRepository): GetAllProducts {
        return GetAllProducts(ecommerceRepository)
    }

    @EcommerceScope
    @Provides
    fun provideEcommerceRepository(ecommerceSource: EcommerceSource): EcommerceRepository {
        return EcommerceRepository(ecommerceSource)
    }

    @EcommerceScope
    @Provides
    fun provideEcommerceSource(): EcommerceSource {
        return EcommerceSourceImpl(
            TryoutApplication.applicationContext()
        )
    }
}