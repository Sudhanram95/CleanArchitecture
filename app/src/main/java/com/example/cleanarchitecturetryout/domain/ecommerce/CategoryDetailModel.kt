package com.example.cleanarchitecturetryout.domain.ecommerce

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CategoryDetailModel : Serializable {
    @SerializedName("category_name")
    lateinit var categoryName: String
    @SerializedName("category_id")
    var categoryId: Int = 0
    @SerializedName("category_image")
    lateinit var categoryImage: String
    @SerializedName("item_list")
    lateinit var itemList: List<ProductDetailModel>

    var isLeft = false
}