package com.example.cleanarchitecturetryout.ui.ecommerce.cart.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturetryout.data.network.Resource
import com.example.cleanarchitecturetryout.domain.cart.CartModel
import com.example.cleanarchitecturetryout.interactor.cart.GetAllCartItems
import com.example.cleanarchitecturetryout.interactor.cart.GetGrandTotal
import com.example.cleanarchitecturetryout.interactor.cart.RemoveFromCart
import com.example.cleanarchitecturetryout.interactor.cart.UpdateCart
import com.example.cleanarchitecturetryout.ui.ecommerce.cart.model.CartUpdateModel
import javax.inject.Inject

class CartViewModel @Inject constructor(
    val getAllCartItems: GetAllCartItems,
    val updateCart: UpdateCart,
    val removeFromCart: RemoveFromCart,
    val getGrandTotal: GetGrandTotal
): ViewModel() {

    private val getAllCartItemsLiveData = MutableLiveData<Resource<List<CartModel>>>()
    private val itemUpdateLiveData = MutableLiveData<Resource<CartUpdateModel>>()
    private val grandTotalLiveData = MutableLiveData<Int>()

    fun observeGetAllCartItems() = getAllCartItemsLiveData
    fun observeItemUpdate() = itemUpdateLiveData
    fun observeGrandTotal() = grandTotalLiveData

    fun getAllCartItemsFromDb() {
        val cartList = getAllCartItems()
        if (!cartList.isEmpty()) {
            getAllCartItemsLiveData.value = Resource.success(cartList)
        } else {
            getAllCartItemsLiveData.value = Resource.error(Throwable("Cart is Empty"), null)
        }
    }

    fun updateItemQuantity(cartModel: CartModel, position: Int, isIncrement: Boolean) {
        cartModel.quantity = if (isIncrement) {
                                cartModel.quantity + 1
                            } else {
                                cartModel.quantity - 1
                            }
        cartModel.subTotal = cartModel.itemPrice * cartModel.quantity

        val cartUpdateModel = CartUpdateModel()
        cartUpdateModel.position = position
        cartUpdateModel.cartModel = cartModel

        if (cartModel.quantity > 1 && cartModel.quantity < 10) {
            updateCart(cartModel)
            itemUpdateLiveData.value = Resource.success(cartUpdateModel)
        } else if (cartModel.quantity == 0) {
            removeFromCart(cartModel)
            itemUpdateLiveData.value = Resource.error(Throwable("Item removed from cart"), cartUpdateModel)
        }
    }

    fun updateGrabdTotal() {
        val grandTotal = getGrandTotal()
        grandTotalLiveData.value = grandTotal
    }
}