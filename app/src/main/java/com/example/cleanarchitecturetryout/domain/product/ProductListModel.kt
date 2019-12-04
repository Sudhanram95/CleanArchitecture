package com.example.cleanarchitecturetryout.domain.product

data class ProductListModel(
    var products: Map<String, List<ProductDetailModel>>
)