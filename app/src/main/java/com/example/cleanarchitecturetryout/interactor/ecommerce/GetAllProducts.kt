package com.example.cleanarchitecturetryout.interactor.ecommerce

import com.example.cleanarchitecturetryout.data.ecommerce.EcommerceRepository

class GetAllProducts(val ecommerceRepository: EcommerceRepository) {

    operator fun invoke() = ecommerceRepository.getAllProducts()
}