package com.example.hummersystemstestapp.domain

import com.example.hummersystemstestapp.data.models.BannerItem
import com.example.hummersystemstestapp.data.models.CategoryItem
import com.example.hummersystemstestapp.data.models.ProductResponse
import com.example.hummersystemstestapp.data.repository.ProductsRepository
import com.example.hummersystemstestapp.data.repository.Repository
import io.reactivex.Single

class ProductsInteractor {

    fun getSeaProducts(): Single<List<ProductResponse>> {
        return ProductsRepository.getSeaProducts()
    }

    fun getSteaks(): Single<List<ProductResponse>> {
        return ProductsRepository.getSteaks()
    }

    fun getPizzas(): Single<List<ProductResponse>> {
        return ProductsRepository.getPizzas()
    }

    fun getBurgers(): Single<List<ProductResponse>> {
        return ProductsRepository.getBurgers()
    }

    fun getBreakfasts(): Single<List<ProductResponse>> {
        return ProductsRepository.getSeaProducts()
    }

    fun getSoups(): Single<List<ProductResponse>> {
        return ProductsRepository.getSoups()
    }

    fun getPorridges(): Single<List<ProductResponse>> {
        return ProductsRepository.getPorridges()
    }

    fun getBanners(): List<BannerItem> {
        return Repository.getBanners()
    }

    fun getCategories(): List<CategoryItem> {
        return Repository.getCategories()
    }
}