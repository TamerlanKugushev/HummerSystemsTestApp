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

    init {
        loadProducts()
    }

    override fun bindView(view: ProductsView) {
        super.bindView(view)
        subscribeTaskList()
        updateBanners()
        updateCategories()
    }

    private fun updateBanners() {
        getView()?.updateBanners(banners = productsInteractor.getBanners())
    }

    private fun updateCategories() {
        getView()?.updateCategories(categories = productsInteractor.getCategories())
    }

    private fun loadProducts() {
        productsInteractor.getProducts()
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