package com.example.cleanarchitecturetryout.ui.ecommerce.cart.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturetryout.data.network.Resource
import com.example.cleanarchitecturetryout.domain.cart.CartModel
import com.example.cleanarchitecturetryout.interactor.cart.GetAllCartItems
import javax.inject.Inject

class CartViewModel @Inject constructor(
    val getAllCartItems: GetAllCartItems
): ViewModel() {

    private val getAllCartItemsLiveData = MutableLiveData<Resource<List<CartModel>>>()

    fun observeGetAllCartItems() = getAllCartItemsLiveData

    fun getAllCartItemsFromDb() {
        val cartList = getAllCartItems()
        if (!cartList.isEmpty()) {
            getAllCartItemsLiveData.value = Resource.success(cartList)
        } else {
            getAllCartItemsLiveData.value = Resource.error(Throwable("Cart is Empty"), null)
        }
    }
}