package com.example.cleanarchitecturetryout.data.cart

import com.example.cleanarchitecturetryout.domain.cart.CartModel

class CartRepository(val cartSource: CartSource) {
    fun getAllCartItems() = cartSource.getAllCartItems()

    fun getItemCount() = cartSource.getItemCount()

    fun addToCart(cartModel: CartModel): Long {
        return cartSource.addCart(cartModel)
    }

    fun updateCart(cartModel: CartModel) {
        cartSource.updateCart(cartModel)
    }

    fun removeFromCart(cartModel: CartModel) {
        cartSource.removeFromCart(cartModel)
    }

    fun getGrandTotal() = cartSource.getGrantTotal()
}