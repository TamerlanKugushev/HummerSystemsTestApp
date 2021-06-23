package com.example.hummersystemstestapp.presentation

import com.example.hummersystemstestapp.data.models.BannerItem
import com.example.hummersystemstestapp.data.models.CategoryItem
import com.example.hummersystemstestapp.data.models.ProductResponse
import com.example.hummersystemstestapp.utils.BaseView

interface ProductsView : BaseView {

    fun updateProducts(products: List<ProductResponse>)

    fun updateBanners(banners: List<BannerItem>)

    fun updateCategories(categories: List<CategoryItem>)

}