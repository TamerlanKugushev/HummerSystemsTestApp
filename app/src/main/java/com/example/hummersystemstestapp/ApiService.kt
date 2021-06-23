package com.example.hummersystemstestapp

import com.example.hummersystemstestapp.data.models.ProductResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("category/39")
    fun getProducts(@Query("page") page: Int): Single<List<ProductResponse>>

}