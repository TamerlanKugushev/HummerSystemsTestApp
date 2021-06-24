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

    fun gatCategoryProducts(position: Int): Single<List<ProductResponse>> {
        return when (position) {
            0 -> ProductsRepository.getSeaProducts()
            1 -> ProductsRepository.getSteaks()
            2 -> ProductsRepository.getPizzas()
            3 -> ProductsRepository.getFettuccine()
            4 -> ProductsRepository.getSauces()
            5 -> ProductsRepository.getPickles()
            6 -> ProductsRepository.getKebabs()
            7 -> ProductsRepository.getDrinks()
            8 -> ProductsRepository.getBurgers()
            9 -> ProductsRepository.getBreakfasts()
            10 -> ProductsRepository.getSoups()
            11 -> ProductsRepository.getPorridges()
            else -> {
                ProductsRepository.getSeaProducts()
            }
        }
    }

    fun getBanners(): List<BannerItem> {
        return Repository.getBanners()
    }

    fun getCategories(): List<CategoryItem> {
        return Repository.getCategories()
    }
}