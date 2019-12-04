package com.example.cleanarchitecturetryout.domain.categorylist

import java.io.Serializable

data class CategoryDetailModel(
    var categoryName: String,
    var categoryId: String,
    var categoryImage: String,
    var isLeft: Boolean
): Serializable