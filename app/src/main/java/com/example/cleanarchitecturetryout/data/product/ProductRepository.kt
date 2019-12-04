package com.example.cleanarchitecturetryout.data.product

class ProductRepository(val source: ProductSource) {

    fun getAllProductsByCategory(categoryId: String) = source.getAllProductsByCategory(categoryId)
}