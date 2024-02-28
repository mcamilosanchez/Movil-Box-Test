package com.example.testmovilbox.data.mapper

import com.example.testmovilbox.data.ProductEntity
import com.example.testmovilbox.domain.model.ProductModel

fun ProductEntity.toModel(): ProductModel {
    with(this) {
        return ProductModel(
            id,
            title,
            description,
            price,
            discountPercentage,
            rating,
            stock,
            brand,
            category,
            thumbnail,
            //images
        )
    }
}