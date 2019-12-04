package com.example.cleanarchitecturetryout.framework.source.product

import android.content.Context
import android.util.Log
import com.example.cleanarchitecturetryout.data.product.ProductSource
import com.example.cleanarchitecturetryout.domain.product.ProductDetailModel
import com.example.cleanarchitecturetryout.domain.product.ProductListModel
import com.google.gson.Gson
import java.io.IOException
import java.nio.charset.Charset

class ProductSourceImpl(val context: Context) : ProductSource {

    override fun getAllProductsByCategory(categoryId: String): List<ProductDetailModel>? {
        val productMap = getAllProducts()
        Log.e("ProductList", "Map: ${Gson().toJson(productMap)}")
        return productMap.get(categoryId)
    }

    private fun getAllProducts(): Map<String, List<ProductDetailModel>> {
        var json = ""
        try {
            val inputStream = context.assets.open("product_list.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return (Gson().fromJson(json, ProductListModel::class.java)).products
    }
}