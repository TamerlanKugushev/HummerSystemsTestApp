package com.example.hummersystemstestapp.domain

import com.example.hummersystemstestapp.data.ProductResponse
import com.example.hummersystemstestapp.data.ProductsRepository
import io.reactivex.Single

class ProductsInteractor {

    fun getProducts(): Single<List<ProductResponse>> {
        return ProductsRepository.getProducts()
    }
}