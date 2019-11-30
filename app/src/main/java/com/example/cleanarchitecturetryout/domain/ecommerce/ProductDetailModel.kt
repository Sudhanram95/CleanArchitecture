package com.example.cleanarchitecturetryout.domain.ecommerce

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ProductDetailModel: Serializable {
    @SerializedName("item_id")
    var itemId: Int = 0
    @SerializedName("name")
    lateinit var name: String
    @SerializedName("description")
    lateinit var description: String
    @SerializedName("price")
    var price: Int = 0
    @SerializedName("images")
    lateinit var imageList: List<String>
}