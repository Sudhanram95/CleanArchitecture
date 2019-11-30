package com.example.cleanarchitecturetryout.framework.source.ecommerce

import android.content.Context
import com.example.cleanarchitecturetryout.data.ecommerce.EcommerceSource
import com.example.cleanarchitecturetryout.domain.ecommerce.CategoryListModel
import com.google.gson.Gson
import java.io.IOException
import java.nio.charset.Charset

class EcommerceSourceImpl(val context: Context): EcommerceSource {

    override fun getAllProducts(): CategoryListModel {
        var json = ""
        try {
            val inputStream = context.assets.open("products.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return Gson().fromJson(json, CategoryListModel::class.java)
    }
}