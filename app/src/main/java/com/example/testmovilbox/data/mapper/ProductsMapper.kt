package com.example.testmovilbox.data.mapper

import com.example.testmovilbox.data.ProductEntity
import com.example.testmovilbox.data.entity.ProductsEntity
import com.example.testmovilbox.domain.model.ProductModel
import com.example.testmovilbox.domain.model.ProductsModel

fun ProductsEntity.toModel(): ProductsModel {
    with(this) {
        return ProductsModel(
            products?.map {
              it.toModel()
            },
            total,
            skip,
            limit
        )
    }
}