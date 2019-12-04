package com.example.cleanarchitecturetryout.domain.product

import java.io.Serializable

data class ProductDetailModel(
    var productId: Int,
    var name: String,
    var images: List<String>,
    var description: String,
    var price: Int
): Serializable