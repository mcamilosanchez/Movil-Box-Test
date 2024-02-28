package com.example.testmovilbox.app.ui.products
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testmovilbox.databinding.ActivityMainBinding
import com.example.testmovilbox.domain.model.ProductModel
import com.example.testmovilbox.utils.CustomDialog
import com.example.testmovilbox.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {

    private val viewModel: ProductViewModel by viewModels()

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val customDialog by lazy {
        CustomDialog(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        callListProducts()
    }

    private fun callListProducts() {
        viewModel.getListProducts().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        customDialog.dismissLoadingDialog()
                        resource.data?.products?.let { it ->
                            customDialog.dismissLoadingDialog()
                            showProductList(it)
                        }
                    }
                    Status.ERROR -> {
                        customDialog.showConfirmationDialog(
                            "Error:",
                            "Problema con el internet.",
                            positiveButtonListener = {
                                customDialog.dismissLoadingDialog()
                            }
                        )
                    }
                    Status.LOADING -> {
                        customDialog.showLoadingDialog()
                    }
                }
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showProductList(productList: List<ProductModel>) {
        val adapter = ProductAdapter(productList, onItemSelected = {product -> onItemSelected(product)})
        binding.rvListProducts.layoutManager = GridLayoutManager(this, 2)
        binding.rvListProducts.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun onItemSelected(productModel: ProductModel) {
        Toast.makeText(this, productModel.title, Toast.LENGTH_LONG).show()
    }

}