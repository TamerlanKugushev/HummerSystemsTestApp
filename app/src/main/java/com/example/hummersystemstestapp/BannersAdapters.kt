package com.example.hummersystemstestapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_banner.view.*

class BannersAdapters :
    ListAdapter<BannerItem, BannersAdapters.BannerViewHolder>(BannerDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
        return BannersAdapters.BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(bannerItem: BannerItem) {
            itemView.imageViewBanner.setImageResource(bannerItem.image)
        }
    }


    class BannerDiffUtilCallback : DiffUtil.ItemCallback<BannerItem>() {

        override fun areItemsTheSame(oldItem: BannerItem, newItem: BannerItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: BannerItem,
            newItem: BannerItem
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}