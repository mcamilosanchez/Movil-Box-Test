package com.example.testmovilbox.domain.database

import androidx.room.TypeConverter
import com.example.testmovilbox.domain.model.ProductModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun setTypeDevice(value: ArrayList<String>?): String? {
        val gson = Gson()
        val type = object : TypeToken<ProductModel?>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun getTypeDevice(value: String?): ArrayList<String>? {
        val gson = Gson()
        val type = object : TypeToken<ProductModel?>() {}.type
        return gson.fromJson(value, type)
    }
}