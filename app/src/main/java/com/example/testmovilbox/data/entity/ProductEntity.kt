package com.example.testmovilbox.data

import com.google.gson.annotations.SerializedName


data class ProductEntity (

    @SerializedName("id")
    val id : Int,

    @SerializedName("title")
    val title : String,

    @SerializedName("description")
    val description : String,

    @SerializedName("price")
    val price : Int,

    @SerializedName("discountPercentage" )
    val discountPercentage : Double,

    @SerializedName("rating")
    val rating : String,

    @SerializedName("stock")
    val stock : Int,

    @SerializedName("brand")
    val brand : String,

    @SerializedName("category")
    val category : String,

    @SerializedName("thumbnail")
    val thumbnail : String,

    @SerializedName("images")
    val images : ArrayList<String> = arrayListOf()

)





