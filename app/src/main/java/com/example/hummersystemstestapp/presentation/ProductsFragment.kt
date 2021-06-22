package com.example.hummersystemstestapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hummersystemstestapp.ProductsAdapter
import com.example.hummersystemstestapp.R
import com.example.hummersystemstestapp.data.ProductResponse
import com.example.hummersystemstestapp.utils.BaseFragment
import com.example.hummersystemstestapp.utils.PresentersStorage
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.android.synthetic.main.fragment_main.*


class ProductsFragment : BaseFragment(), ProductsView {

    companion object {
        fun newInstance(): ProductsFragment {
            return ProductsFragment()
        }
    }

    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var presenter: ProductsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productsAdapter = ProductsAdapter()
        productsRecyclerView.setHasFixedSize(true)
        productsRecyclerView.adapter = productsAdapter
        productsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        initSpinner()
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

    private fun initSpinner() {
        val spinnerAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.cities,
            R.layout.spinner_item
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerProducts.adapter = spinnerAdapter
    }
}
