package com.example.hummersystemstestapp.data

import com.example.hummersystemstestapp.RetrofitHolder
import io.reactivex.Single

object ProductsRepository {

    private val apiService = RetrofitHolder.apiService

    fun getProducts(): Single<List<ProductResponse>> {
        return apiService
            .getProducts(
                RetrofitHolder.PAGE
            )
    }
}