package com.example.hummersystemstestapp.data.repository

import com.example.hummersystemstestapp.data.models.BannerItem
import com.example.hummersystemstestapp.R
import com.example.hummersystemstestapp.data.models.CategoryItem

object Repository {
    private val mockBanners = listOf(
        BannerItem(R.drawable.banner),
        BannerItem(R.drawable.banner),
        BannerItem(R.drawable.banner),
        BannerItem(R.drawable.banner),
        BannerItem(R.drawable.banner)
    )

    private val mockCategories= listOf(
        CategoryItem("Морские продукты"),
        CategoryItem("Стейки"),
        CategoryItem("Пиццы"),
        CategoryItem("Фетуччини"),
        CategoryItem("Соусы"),
        CategoryItem("Соленья"),
        CategoryItem("Шашлыки"),
        CategoryItem("Напитки"),
        CategoryItem("Бургеры"),
        CategoryItem("Завтраки"),
        CategoryItem("Супы"),
        CategoryItem("Каши"),
    )

    fun getBanners(): List<BannerItem> {
        return mockBanners
    }

    fun getCategories():List<CategoryItem>{
        return mockCategories
    }

}