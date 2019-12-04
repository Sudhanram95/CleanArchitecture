package com.example.cleanarchitecturetryout.data.categorylist

class CategoryListRepository(val source: CategoryListSource) {
    fun getAllCategories() = source.getAllCategories()
}