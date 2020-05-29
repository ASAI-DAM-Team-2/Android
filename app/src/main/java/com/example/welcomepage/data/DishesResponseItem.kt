package com.example.welcomepage.data


import com.google.gson.annotations.SerializedName

data class DishesResponseItem(
    val description: String,
    @SerializedName("dish_id")
    val dishId: Int,
    val name: String,
    val picture: String,
    val price: Double,
    @SerializedName("restaurant_id")
    val restaurantId: Int,
    val title: String
)