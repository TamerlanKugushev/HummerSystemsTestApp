package com.example.hummersystemstestapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hummersystemstestapp.data.ProductResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class ProductsAdapter :
    ListAdapter<ProductResponse, ProductsAdapter.CatalogViewHolder>(CatalogDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CatalogViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    class CatalogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(productResponse: ProductResponse) {
            val url = productResponse.image
            Picasso.with(itemView.context)
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

        override fun areContentsTheSame(
            oldItem: ProductResponse,
            newItem: ProductResponse
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}