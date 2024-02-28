package com.example.testmovilbox.domain.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testmovilbox.domain.model.ProductModel

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProduct(productModel: ProductModel)

    @Query("SELECT * FROM product_table ORDER BY rating DESC")
    suspend fun getAllProduct() : List<ProductModel>
}