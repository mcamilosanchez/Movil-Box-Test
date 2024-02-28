package com.example.testmovilbox.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

@Entity(tableName = "product_table")
data class ProductModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "price") val price: Int?,
    @ColumnInfo(name = "discountPercentage") val discountPercentage: Double,
    @ColumnInfo(name = "rating") val rating: String,
    @ColumnInfo(name = "stock") val stock: Int,
    @ColumnInfo(name = "brand") val brand: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "thumbnail") val thumbnail: String,
  //  @ColumnInfo(name = "images") val images: ArrayList<String> = arrayListOf()
) {
    fun getFormattedPrice() = price.formattedPrice()
}

fun Int?.formattedPrice(): String {
    val priceValue = this.toString().toDoubleOrNull() ?: 0.0
    val numberFormat = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
    return numberFormat.format(priceValue)
}


