package com.example.welcomepage

import kotlinx.coroutines.Deferred
import okhttp3.Response
import retrofit2.http.GET

interface Api {
    @GET("/Restaurant")
    fun getRestaurant(): Deferred<Response<RestaurantResponse>>
}