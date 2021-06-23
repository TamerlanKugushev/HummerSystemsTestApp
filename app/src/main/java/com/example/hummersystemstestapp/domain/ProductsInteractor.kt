package com.example.hummersystemstestapp.domain

import com.example.hummersystemstestapp.BannerItem
import com.example.hummersystemstestapp.data.ProductResponse
import com.example.hummersystemstestapp.data.repository.ProductsRepository
import com.example.hummersystemstestapp.data.repository.Repository
import io.reactivex.Single

class ProductsInteractor {

    fun getProducts(): Single<List<ProductResponse>> {
        return ProductsRepository.getProducts()
    }

    fun getBanners(): List<BannerItem> {
        return Repository.getBanners()
    }
}