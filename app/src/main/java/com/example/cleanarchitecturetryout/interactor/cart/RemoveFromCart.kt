package com.example.cleanarchitecturetryout.interactor.cart

import com.example.cleanarchitecturetryout.data.cart.CartRepository
import com.example.cleanarchitecturetryout.domain.cart.CartModel

class RemoveFromCart(val cartRepository: CartRepository) {
    operator fun invoke(cartModel: CartModel) {
        cartRepository.removeFromCart(cartModel)
    }
}