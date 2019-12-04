package com.example.cleanarchitecturetryout.ui.ecommerce.productlist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturetryout.data.network.Resource
import com.example.cleanarchitecturetryout.domain.product.ProductDetailModel
import com.example.cleanarchitecturetryout.interactor.product.GetAllProductsByCategory
import javax.inject.Inject

class ProductListViewModel @Inject constructor(
    val getAllProductsByCategory: GetAllProductsByCategory
): ViewModel() {

    private val allProductsLiveData = MutableLiveData<Resource<List<ProductDetailModel>>>()

    fun observeAllProducts() = allProductsLiveData

    fun getAllProducts(categoryId: String) {
        val productList = getAllProductsByCategory(categoryId)

        if (productList != null) {
            allProductsLiveData.value = Resource.success(productList)
        } else {
            allProductsLiveData.value = Resource.error(Throwable("Something went wrong"), null)
        }
    }
}