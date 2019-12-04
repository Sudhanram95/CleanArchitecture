package com.example.cleanarchitecturetryout.interactor.product

import com.example.cleanarchitecturetryout.data.product.ProductRepository

class GetAllProductsByCategory(val repository: ProductRepository) {
    operator fun invoke(categoryId: String) = repository.getAllProductsByCategory(categoryId)
}