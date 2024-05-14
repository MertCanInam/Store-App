package com.mertinam.storeapp.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id")
    val id : String,
    @SerializedName("title")
    val title : String,
    @SerializedName("price")
    val price : Double,
    @SerializedName("category")
    val category : String,
    @SerializedName("description")
    val description : String,
    @SerializedName("image")
    val imageUrl : String

)