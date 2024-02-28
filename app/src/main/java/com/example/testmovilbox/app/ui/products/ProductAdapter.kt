package com.example.testmovilbox.app.ui.products

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testmovilbox.databinding.ItemProductBinding
import com.example.testmovilbox.domain.model.ProductModel

class ProductAdapter(
    private val productList: List<ProductModel>,
    private val onItemSelected: (ProductModel) -> Unit,
) : ListAdapter<ProductModel, ProductAdapter.ProductViewHolder>(DiffUtilProduct()) {

    class ProductViewHolder(
        private val binding: ItemProductBinding
        ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: ProductModel){
            binding.product = product
            Glide.with(binding.imgProductImage)
                .load(product.thumbnail)
                .into(binding.imgProductImage)
            binding.executePendingBindings()
            //binding.viewHolderProducts.setOnClickListener { onItemSelected(product) }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {
        val product = productList[position]
        holder.bind(product)


    }

    override fun getItemCount(): Int {
        return productList.size
    }

}