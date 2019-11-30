package com.example.cleanarchitecturetryout.interactor.cart

import com.example.cleanarchitecturetryout.data.cart.CartRepository

class GetItemCount(val cartRepository: CartRepository) {
    operator fun invoke() = cartRepository.getItemCount()
}