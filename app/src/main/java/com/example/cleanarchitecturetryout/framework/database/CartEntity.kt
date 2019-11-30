package com.example.cleanarchitecturetryout.framework.database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_table")
data class CartEntity(
    @PrimaryKey
    @NonNull
    var productId: Int = 0,
    var productName: String,
    var productImage: String,
    var quantity: Int = 0,
    var itemPrice: Int = 0,
    var subTotal: Int = 0
)