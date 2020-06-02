package com.example.welcomepage.data


import com.google.gson.annotations.SerializedName

data class RestaurantResponseItem(
    @SerializedName("restaurant_id")
    val restaurantId: Int,
    val name: String,
    val address: String,
    @SerializedName("plan_id")
    val planId: Int,
    @SerializedName("company_id")
    val companyId: Int
)