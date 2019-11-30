package com.example.cleanarchitecturetryout.ui.ecommerce.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturetryout.data.network.Resource
import com.example.cleanarchitecturetryout.domain.ecommerce.CategoryListModel
import com.example.cleanarchitecturetryout.interactor.ecommerce.GetAllProducts
import javax.inject.Inject

class EcommerceViewModel @Inject constructor(val getAllProducts: GetAllProducts): ViewModel() {

    val productsLiveData = MutableLiveData<Resource<CategoryListModel>>()

    fun observeProducts() = productsLiveData

    fun getAllProductsResponse() {
        val productsList = getAllProducts()
        if (productsList != null) {
            productsLiveData.value = Resource.success(productsList)
        } else {
            productsLiveData.value = Resource.error(Throwable("Empty model"), null)
        }
    }
}