package com.example.cleanarchitecturetryout.interactor.cart

import com.example.cleanarchitecturetryout.data.cart.CartRepository

class GetAllCartItems(val cartRepository: CartRepository) {
    operator fun invoke() = cartRepository.getAllCartItems()
}