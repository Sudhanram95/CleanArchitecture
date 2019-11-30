package com.example.cleanarchitecturetryout.domain.ecommerce

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CategoryListModel: Serializable {
    @SerializedName("category_list")
    lateinit var categoryList: List<CategoryDetailModel>
}