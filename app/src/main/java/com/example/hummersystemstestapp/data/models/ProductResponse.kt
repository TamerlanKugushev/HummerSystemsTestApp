package com.example.hummersystemstestapp.data.models

import com.google.gson.annotations.SerializedName


data class ProductResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("price")
    val price: Int,

    @SerializedName("oldPrice")
    val oldPrice: Int,

    @SerializedName("description")
    val description: String,

    @SerializedName("isFavorite")
    val isFavorite: Any?
)