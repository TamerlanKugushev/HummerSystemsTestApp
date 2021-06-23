package com.example.hummersystemstestapp.data.repository

import com.example.hummersystemstestapp.BannerItem
import com.example.hummersystemstestapp.R

object Repository {
    private val mockBanners = listOf(
        BannerItem(R.drawable.banner),
        BannerItem(R.drawable.banner),
        BannerItem(R.drawable.banner),
        BannerItem(R.drawable.banner),
        BannerItem(R.drawable.banner)
    )

    fun getBanners(): List<BannerItem> {
        return mockBanners
    }

}