package com.example.cleanarchitecturetryout.data.categorylist

import com.example.cleanarchitecturetryout.domain.categorylist.CategoryDetailModel

interface CategoryListSource {
    fun getAllCategories(): List<CategoryDetailModel>
}