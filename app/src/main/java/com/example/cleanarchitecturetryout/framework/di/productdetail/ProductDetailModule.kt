package com.example.cleanarchitecturetryout.framework.di.productdetail

import com.example.cleanarchitecturetryout.data.cart.CartRepository
import com.example.cleanarchitecturetryout.data.cart.CartSource
import com.example.cleanarchitecturetryout.framework.source.cart.CartSourceImpl
import com.example.cleanarchitecturetryout.interactor.cart.AddToCart
import com.example.cleanarchitecturetryout.ui.TryoutApplication
import dagger.Module
import dagger.Provides

@Module
class ProductDetailModule {

    @ProductDetailScope
    @Provides
    fun provideAddToCart(cartRepository: CartRepository): AddToCart {
        return AddToCart(cartRepository)
    }

    @ProductDetailScope
    @Provides
    fun provideCartRepository(cartSource: CartSource): CartRepository {
        return CartRepository(cartSource)
    }

    @ProductDetailScope
    @Provides
    fun provideCartSource(): CartSource {
        return CartSourceImpl(TryoutApplication.applicationContext())
    }
}