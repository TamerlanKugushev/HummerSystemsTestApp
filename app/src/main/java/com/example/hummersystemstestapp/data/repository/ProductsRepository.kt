package com.example.hummersystemstestapp.data.repository

import com.example.hummersystemstestapp.RetrofitHolder
import com.example.hummersystemstestapp.data.models.ProductResponse
import io.reactivex.Single

object ProductsRepository {

    private val apiService = RetrofitHolder.apiService

    // Морские продукты
    fun getSeaProducts(): Single<List<ProductResponse>> {
        return apiService.getProducts(2,RetrofitHolder.PAGE)
    }

    // Стейки
    fun getSteaks(): Single<List<ProductResponse>> {
        return apiService.getProducts(7,RetrofitHolder.PAGE)
    }

    // Пиццы
    fun getPizzas(): Single<List<ProductResponse>> {
        return apiService.getProducts(9, RetrofitHolder.PAGE)
    }

    // Фетуччини
    fun getFettuccine(): Single<List<ProductResponse>> {
        return apiService.getProducts(10,RetrofitHolder.PAGE)
    }

    // Соусы
    fun getSauces(): Single<List<ProductResponse>> {
        return apiService.getProducts(13,RetrofitHolder.PAGE)
    }

    // Соленья
    fun getPickles(): Single<List<ProductResponse>> {
        return apiService.getProducts(14,RetrofitHolder.PAGE)
    }

    // Шашлыки
    fun getKebabs(): Single<List<ProductResponse>> {
        return apiService.getProducts(15,RetrofitHolder.PAGE)
    }

    // Напитки
    fun getDrinks(): Single<List<ProductResponse>> {
        return apiService.getProducts(16,RetrofitHolder.PAGE)
    }

    // Бургеры
    fun getBurgers(): Single<List<ProductResponse>> {
        return apiService.getProducts(30, RetrofitHolder.PAGE)
    }

    // Завтраки
    fun getBreakfasts(): Single<List<ProductResponse>> {
        return apiService.getProducts(32, RetrofitHolder.PAGE)
    }

    // Супы
    fun getSoups(): Single<List<ProductResponse>> {
        return apiService.getProducts(33, RetrofitHolder.PAGE)
    }

    // Каши
    fun getPorridges(): Single<List<ProductResponse>> {
        return apiService.getProducts(39, RetrofitHolder.PAGE)
    }
}