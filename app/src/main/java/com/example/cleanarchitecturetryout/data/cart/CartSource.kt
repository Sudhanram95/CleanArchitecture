package com.example.cleanarchitecturetryout.data.cart

import com.example.cleanarchitecturetryout.domain.cart.CartModel

interface CartSource {
    fun getAllCartItems(): List<CartModel>
    fun getItemCount(): Int
    fun addCart(cartModel: CartModel): Long
    fun updateCart(cartModel: CartModel)
    fun removeFromCart(cartModel: CartModel)
    fun getGrantTotal(): Int
}