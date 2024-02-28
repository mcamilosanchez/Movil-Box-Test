package com.example.testmovilbox.domain.repository

import com.example.testmovilbox.domain.database.dao.ProductDao
import com.example.testmovilbox.domain.model.ProductModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    private val productDao : ProductDao
) {
    suspend fun saveProduct(productModel: ProductModel) = productDao.saveProduct(productModel)
}