package com.example.testmovilbox.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testmovilbox.domain.database.dao.ProductDao
import com.example.testmovilbox.domain.model.ProductModel

@Database(entities = [ProductModel::class], version = 1, exportSchema = false)
//@TypeConverters(Converters::class)
abstract class ProductDataBase : RoomDatabase() {
    abstract fun getProductDao() : ProductDao
}