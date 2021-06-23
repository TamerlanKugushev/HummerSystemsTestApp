package com.example.hummersystemstestapp.data.repository

import com.example.hummersystemstestapp.RetrofitHolder
import com.example.hummersystemstestapp.data.models.ProductResponse
import io.reactivex.Single

object ProductsRepository {

    private val apiService = RetrofitHolder.apiService

    fun getProducts(): Single<List<ProductResponse>> {
        return apiService.getProducts(RetrofitHolder.PAGE)
    }
}