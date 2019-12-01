package com.example.cleanarchitecturetryout.framework.di.cart

import com.example.cleanarchitecturetryout.data.cart.CartRepository
import com.example.cleanarchitecturetryout.data.cart.CartSource
import com.example.cleanarchitecturetryout.framework.source.cart.CartSourceImpl
import com.example.cleanarchitecturetryout.interactor.cart.GetAllCartItems
import com.example.cleanarchitecturetryout.interactor.cart.GetGrandTotal
import com.example.cleanarchitecturetryout.interactor.cart.RemoveFromCart
import com.example.cleanarchitecturetryout.interactor.cart.UpdateCart
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
    fun provideUpdateCart(cartRepository: CartRepository): UpdateCart {
        return UpdateCart(cartRepository)
    }

    @CartScope
    @Provides
    fun provideRemoveFromCart(cartRepository: CartRepository): RemoveFromCart {
        return RemoveFromCart(cartRepository)
    }

    @CartScope
    @Provides
    fun provideGetGrandTotal(cartRepository: CartRepository): GetGrandTotal {
        return GetGrandTotal(cartRepository)
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