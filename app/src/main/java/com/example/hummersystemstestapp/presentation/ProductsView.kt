package com.example.hummersystemstestapp.presentation

import com.example.hummersystemstestapp.data.ProductResponse
import com.example.hummersystemstestapp.utils.BaseView

interface ProductsView:BaseView {

    fun updateProducts(products: List<ProductResponse>)

}