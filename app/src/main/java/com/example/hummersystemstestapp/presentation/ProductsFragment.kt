package com.example.hummersystemstestapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.hummersystemstestapp.data.models.BannerItem
import com.example.hummersystemstestapp.adapters.ProductsAdapter
import com.example.hummersystemstestapp.R
import com.example.hummersystemstestapp.adapters.BannersAdapter
import com.example.hummersystemstestapp.adapters.CategoriesAdapter
import com.example.hummersystemstestapp.data.models.CategoryItem
import com.example.hummersystemstestapp.data.models.ProductResponse
import com.example.hummersystemstestapp.utils.BaseFragment
import com.example.hummersystemstestapp.utils.PresentersStorage
import kotlinx.android.synthetic.main.fragment_main.*


class ProductsFragment : BaseFragment(), ProductsView {

    companion object {
        fun newInstance(): ProductsFragment {
            return ProductsFragment()
        }
    }

    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var bannersAdapter: BannersAdapter
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var presenter: ProductsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productsAdapter = ProductsAdapter()
        bannersAdapter = BannersAdapter()
        categoriesAdapter = CategoriesAdapter(onCategoryClick = ::onCategoryClick)
        setRecyclerAdapters()
        setHasFixedSizeRecycler()
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(bannersRecyclerView)
    }

    override fun attachPresenter() {
        val presenter = PresentersStorage.getPresenter(viewId)
        if (presenter !is ProductsPresenter) {
            this.presenter = ProductsPresenter()
            return
        }
        this.presenter = presenter
    }

    override fun getPresenter(): ProductsPresenter {
        return presenter
    }

    override fun onStart() {
        super.onStart()
        presenter.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.unbindView()
    }

    override fun updateProducts(products: List<ProductResponse>) {
        val listCopy = products.toMutableList().map { it.copy() }
        productsAdapter.submitList(listCopy)
    }

    override fun updateBanners(banners: List<BannerItem>) {
        bannersAdapter.setData(banners)
    }

    override fun updateCategories(categories: List<CategoryItem>) {
        categoriesAdapter.setData(categories)
    }

    private fun onCategoryClick(position: Int) {
        presenter.updateProducts(position)
    }

    private fun setRecyclerAdapters() {
        productsRecyclerView.adapter = productsAdapter
        bannersRecyclerView.adapter = bannersAdapter
        categoriesRecyclerView.adapter = categoriesAdapter
    }

    private fun setHasFixedSizeRecycler() {
        productsRecyclerView.setHasFixedSize(true)
        bannersRecyclerView.setHasFixedSize(true)
        categoriesRecyclerView.setHasFixedSize(true)
    }
}
