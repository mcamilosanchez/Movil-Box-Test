package com.example.testmovilbox.domain.model

data class ProductsModel(
    val products: List<ProductModel>?,
    val total: Int,
    val skip: Int,
    val limit: Int
)