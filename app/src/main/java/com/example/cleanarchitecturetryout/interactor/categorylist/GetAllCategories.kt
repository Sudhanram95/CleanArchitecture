package com.example.cleanarchitecturetryout.interactor.categorylist

import com.example.cleanarchitecturetryout.data.categorylist.CategoryListRepository

class GetAllCategories(val repository: CategoryListRepository) {
    operator fun invoke() = repository.getAllCategories()
}