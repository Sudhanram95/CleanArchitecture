package com.example.cleanarchitecturetryout.framework.di.cart

import com.example.cleanarchitecturetryout.data.cart.CartRepository
import com.example.cleanarchitecturetryout.data.cart.CartSource
import com.example.cleanarchitecturetryout.framework.source.cart.CartSourceImpl
import com.example.cleanarchitecturetryout.interactor.cart.GetAllCartItems
import com.example.cleanarchitecturetryout.ui.TryoutApplication
import dagger.Module
import dagger.Provides

@Module
class CartModule {

    @CartScope
    @Provides
    fun provideGetAllCartItems(cartRepository: CartRepository): GetAllCartItems {
        return GetAllCartItems(cartRepository)
    }

    @CartScope
    @Provides
    fun provideCartRepository(cartSource: CartSource): CartRepository {
        return CartRepository(cartSource)
    }

    @CartScope
    @Provides
    fun provideCartSource(): CartSource {
        return CartSourceImpl(TryoutApplication.applicationContext())
    }
}