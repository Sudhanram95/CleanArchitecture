package com.example.cleanarchitecturetryout.domain.product

data class ProductListModel(
    var productMap: Map<String, List<ProductDetailModel>>
)