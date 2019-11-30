package com.example.cleanarchitecturetryout.interactor.cart

import com.example.cleanarchitecturetryout.data.cart.CartRepository

class GetGrandTotal(val cartRepository: CartRepository) {
    operator fun invoke() = cartRepository.getGrandTotal()
}