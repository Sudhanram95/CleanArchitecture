package com.example.cleanarchitecturetryout.data.ecommerce

class EcommerceRepository(val ecommerceSource: EcommerceSource) {

    fun getAllProducts() = ecommerceSource.getAllProducts()
}