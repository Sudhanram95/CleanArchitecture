package com.example.cleanarchitecturetryout.framework.source.cart

import android.content.Context
import android.os.AsyncTask
import com.example.cleanarchitecturetryout.data.cart.CartSource
import com.example.cleanarchitecturetryout.domain.cart.CartModel
import com.example.cleanarchitecturetryout.framework.database.CartDao
import com.example.cleanarchitecturetryout.framework.database.CartEntity
import com.example.cleanarchitecturetryout.framework.database.CartRoomDatabase

class CartSourceImpl(context: Context): CartSource {

    private val cartDao = CartRoomDatabase.getDbInstance(context)!!.cartDao()

    override fun getAllCartItems(): List<CartModel> {
        return cartDao.getAllCartItems().map {
            CartModel(it.productId, it.productName, it.productImage, it.quantity, it.itemPrice, it.subTotal)
        }
    }

    override fun getItemCount(): Int {
        return cartDao.getItemCount()
    }

    override fun addCart(cartModel: CartModel): Long {
        val task = InsertAsyncTask(cartDao).execute(cartModel)
        return task.get()
    }

    override fun updateCart(cartModel: CartModel) {
        UpdateAsyncTask(cartDao).execute(cartModel)
    }

    override fun removeFromCart(cartModel: CartModel) {
        cartDao.removeFromCart(CartEntity(cartModel.productId, cartModel.productName, cartModel.productImage,
            cartModel.quantity, cartModel.itemPrice, cartModel.subTotal))
    }

    override fun getGrantTotal(): Int {
        return cartDao.calculateGrandTotal()
    }

    private class InsertAsyncTask(val cartDao: CartDao?): AsyncTask<CartModel, Void, Long>() {

        override fun doInBackground(vararg params: CartModel): Long {
            val cartModel = params[0]
            return cartDao!!.addToCart(CartEntity(cartModel.productId, cartModel.productName, cartModel.productImage,
                cartModel.quantity, cartModel.itemPrice, cartModel.subTotal))
        }
    }

    private class UpdateAsyncTask(var cartDao: CartDao?): AsyncTask<CartModel, Void, Void>() {

        override fun doInBackground(vararg params: CartModel): Void? {
            val cartModel = params[0]
            cartDao!!.updateCart(CartEntity(cartModel.productId, cartModel.productName, cartModel.productImage,
                cartModel.quantity, cartModel.itemPrice, cartModel.subTotal))
            return null
        }
    }
}