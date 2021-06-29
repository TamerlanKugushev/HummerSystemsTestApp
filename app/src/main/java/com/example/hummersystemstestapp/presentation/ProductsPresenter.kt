package com.example.hummersystemstestapp.presentation

import android.util.Log
import com.example.hummersystemstestapp.data.models.ProductResponse
import com.example.hummersystemstestapp.domain.ProductsInteractor
import com.example.hummersystemstestapp.utils.BasePresenter
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class ProductsPresenter : BasePresenter<ProductsView>() {

    private val productsInteractor = ProductsInteractor()
    private val productsSubject = BehaviorRelay.create<List<ProductResponse>>()
    private val categories = productsInteractor.getCategories()
    private val banners = productsInteractor.getBanners()

    init {
        loadProducts()
    }

    override fun bindView(view: ProductsView) {
        super.bindView(view)
        subscribeTaskList()
        updateBanners()
        updateCategories()
    }

    fun updateProducts(position: Int) {
        productsInteractor.gatCategoryProducts(position)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    getView()?.updateProducts(it)
                    updateCategories(position)
                },
                onError = {
                    Log.e("PRODUCT", it.toString())
                }
            ).addTo(viewCompositeDisposable)
    }

    private fun updateBanners() {
        getView()?.updateBanners(banners)
    }

    private fun updateCategories(position: Int = 0) {
        categories.forEach { it.isPressed = false }
        categories[position].isPressed = true
        getView()?.updateCategories(categories)
    }

    private fun loadProducts() {
        productsInteractor.getSeaProducts()
            .subscribeOn(Schedulers.io())
            .subscribeBy(
                onSuccess = {
                    productsSubject.accept(it)
                },
                onError = {
                    Log.e("PRODUCT", it.toString())
                }
            ).addTo(dataCompositeDisposable)
    }

    private fun subscribeTaskList() {
        productsSubject.hide()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    getView()?.updateProducts(it)
                },
                onError = {
                    Log.e("PRODUCT", it.toString())
                }
            ).addTo(viewCompositeDisposable)
    }

}