package com.example.cleanarchitecturetryout.framework.di.productlist

import com.example.cleanarchitecturetryout.data.product.ProductRepository
import com.example.cleanarchitecturetryout.data.product.ProductSource
import com.example.cleanarchitecturetryout.framework.source.product.ProductSourceImpl
import com.example.cleanarchitecturetryout.interactor.product.GetAllProductsByCategory
import com.example.cleanarchitecturetryout.ui.TryoutApplication
import dagger.Module
import dagger.Provides

@Module
class ProductListModule {

    @ProductListScope
    @Provides
    fun provideGetAllProducts(repository: ProductRepository): GetAllProductsByCategory {
        return GetAllProductsByCategory(repository)
    }

    @ProductListScope
    @Provides
    fun provideProductRepository(source: ProductSource): ProductRepository {
        return ProductRepository(source)
    }

    @ProductListScope
    @Provides
    fun provideProductSource(): ProductSource {
        return ProductSourceImpl(TryoutApplication.applicationContext())
    }
}