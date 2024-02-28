package com.example.testmovilbox.app.ui.products

import androidx.recyclerview.widget.DiffUtil
import com.example.testmovilbox.domain.model.ProductModel

class DiffUtilProduct: DiffUtil.ItemCallback<ProductModel>() {

    override fun areItemsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
        return oldItem.id == newItem.id
    }
}