package com.example.testmovilbox.app.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testmovilbox.data.entity.ProductsEntity
import com.example.testmovilbox.data.mapper.toModel
import com.example.testmovilbox.data.repository.network.ApiService
import com.example.testmovilbox.domain.model.ProductsModel
import com.example.testmovilbox.domain.repository.ProductRepository
import com.example.testmovilbox.utils.Resource
import com.example.testmovilbox.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val status: MutableLiveData<Resource<ProductsModel>> =
        MutableLiveData(Resource.loading(data = null))

    fun getListProducts(): LiveData<Resource<ProductsModel>> {
        viewModelScope.launch {
            try {
                val response = ApiService.Api.retrofitService.getProducts()
                val productsResponse = response.toModel()

                //Save products in database local
                productsResponse.products?.map {
                    productRepository.saveProduct(it)
                }

                status.value = Resource(
                    Status.SUCCESS,
                    productsResponse,
                    "List of products was loaded successfully"
                )
            } catch (e: Exception) {
                e.printStackTrace()
                status.value = Resource(Status.ERROR, null, "Error ViewModelScope")
            }
        }
        return status
    }
}