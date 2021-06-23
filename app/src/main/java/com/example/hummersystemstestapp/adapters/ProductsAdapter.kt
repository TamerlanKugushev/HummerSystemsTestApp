package com.example.hummersystemstestapp.adapters

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hummersystemstestapp.R
import com.example.hummersystemstestapp.data.ProductResponse
import com.example.hummersystemstestapp.inflate
import kotlinx.android.synthetic.main.item_food.view.*

class ProductsAdapter : ListAdapter<ProductResponse, ProductsAdapter.CatalogViewHolder>(
    CatalogDiffUtilCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val view = parent.inflate(R.layout.item_food)
        return CatalogViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CatalogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(productResponse: ProductResponse) {
            val url = productResponse.image
            Glide.with(itemView.context)
                .load(url)
                .into(itemView.imageViewProduct)
            itemView.buttonPrice.text = "от ${productResponse.price} р"
            itemView.textViewTitleOfProduct.text = productResponse.name
            itemView.textViewDescriptionOfProduct.text = productResponse.description
        }
    }

    class CatalogDiffUtilCallback : DiffUtil.ItemCallback<ProductResponse>() {

        override fun areItemsTheSame(oldItem: ProductResponse, newItem: ProductResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductResponse, newItem: ProductResponse): Boolean {
            return oldItem == newItem
        }
    }
}