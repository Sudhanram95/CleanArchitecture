package com.example.cleanarchitecturetryout.framework.database

import androidx.room.*

@Dao
interface CartDao {

    @Query("SELECT * from cart_table")
    fun getAllCartItems(): List<CartEntity>

    @Query("SELECT COUNT(productId) from cart_table")
    fun getItemCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addToCart(cart: CartEntity): Long

    @Update
    fun updateCart(cart: CartEntity)

    @Delete
    fun removeFromCart(cart: CartEntity)

    @Query("SELECT SUM(subTotal) from cart_table")
    fun calculateGrandTotal(): Int
}