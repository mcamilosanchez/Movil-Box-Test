package com.example.testmovilbox.data.repository.network

import com.example.testmovilbox.data.entity.ProductsEntity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val baseUrl = "https://dummyjson.com/"

private val retrofit: Retrofit =
    Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()

class ApiService {

    interface ApiService {
        @GET("products")
        suspend fun getProducts(): ProductsEntity
    }

    object Api {
        val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
    }
}