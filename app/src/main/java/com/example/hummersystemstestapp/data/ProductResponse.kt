package com.example.hummersystemstestapp.data

import com.google.gson.annotations.SerializedName


data class ProductResponse(
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("image")
    var image: String,

    @SerializedName("price")
    var price: Int,

    @SerializedName("oldPrice")
    var oldPrice: Int,

    @SerializedName("description")
    var description: String,

    @SerializedName("isFavorite")
    var isFavorite: Any?
)