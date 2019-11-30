package com.example.cleanarchitecturetryout.domain.cart

data class CartModel (
    var productId: Int = 0,
    var productName: String,
    var productImage: String,
    var quantity: Int = 0,
    var itemPrice: Int = 0,
    var subTotal: Int = 0
)