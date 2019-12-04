package com.example.cleanarchitecturetryout.data.product

import com.example.cleanarchitecturetryout.domain.product.ProductDetailModel

interface ProductSource {
    fun getAllProductsByCategory(categoryId: String): List<ProductDetailModel>?
}