package com.example.hummersystemstestapp

import com.example.hummersystemstestapp.data.models.ProductResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("category/{category}")
    fun getProducts(@Path("category") category: Int,@Query("page") page: Int): Single<List<ProductResponse>>

}