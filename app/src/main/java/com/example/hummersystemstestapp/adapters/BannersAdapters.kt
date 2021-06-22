package com.example.hummersystemstestapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hummersystemstestapp.BannerItem
import com.example.hummersystemstestapp.R
import kotlinx.android.synthetic.main.item_banner.view.*

class BannersAdapters : RecyclerView.Adapter<BannersAdapters.BannerViewHolder>() {
    private var bannerList = emptyList<BannerItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val currentItem = bannerList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return bannerList.size
    }

    fun setData(bannerList: List<BannerItem>) {
        this.bannerList = bannerList
    }

    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(bannerItem: BannerItem) {
            itemView.imageViewBanner.setImageResource(bannerItem.image)
        }
    }
}