package com.example.cleanarchitecturetryout.ui.ecommerce.productdetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturetryout.data.network.Resource
import com.example.cleanarchitecturetryout.domain.cart.CartModel
import com.example.cleanarchitecturetryout.domain.product.ProductDetailModel
import com.example.cleanarchitecturetryout.interactor.cart.AddToCart
import javax.inject.Inject

class ProductDetailViewModel @Inject constructor(val addToCart: AddToCart): ViewModel() {

    val addToCartLiveData = MutableLiveData<Resource<String>>()

    fun observeAddToCart() = addToCartLiveData

    fun addProductToCart(product: ProductDetailModel) {
        val result = addToCart(CartModel(product.productId, product.name, product.images.get(0),
            1, product.price, product.price))

        addToCartLiveData.value = if (result > 0)
                                        Resource.success("Added to cart")
                                else
                                    Resource.error(Throwable(), "Already added to cart")
    }
}