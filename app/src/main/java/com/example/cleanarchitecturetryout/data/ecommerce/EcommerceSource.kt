package com.example.cleanarchitecturetryout.data.ecommerce

import com.example.cleanarchitecturetryout.domain.ecommerce.CategoryDetailModel
import com.example.cleanarchitecturetryout.domain.ecommerce.CategoryListModel

interface EcommerceSource {
    fun getAllProducts(): CategoryListModel?
}