package com.example.cleanarchitecturetryout.framework.source.categorylist

import android.content.Context
import com.example.cleanarchitecturetryout.data.categorylist.CategoryListSource
import com.example.cleanarchitecturetryout.domain.categorylist.CategoryDetailModel
import com.example.cleanarchitecturetryout.domain.categorylist.CategoryListModel
import com.example.cleanarchitecturetryout.domain.product.ProductDetailModel
import com.google.gson.Gson
import java.io.IOException
import java.nio.charset.Charset

class CategoryListSourceImpl(val context: Context) : CategoryListSource {

    override fun getAllCategories(): List<CategoryDetailModel> {
        var json = ""
        try {
            val inputStream = context.assets.open("category_list.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return (Gson().fromJson(json, CategoryListModel::class.java)).categoryList
    }
}