package com.example.testmovilbox.data.entity

import com.example.testmovilbox.data.ProductEntity
import com.google.gson.annotations.SerializedName

data class ProductsEntity (

    @SerializedName("products")
    val products : List<ProductEntity>?,

    @SerializedName("total")
    val total : Int,

    @SerializedName("skip")
    val skip : Int,

    @SerializedName("limit")
    val limit : Int

)
