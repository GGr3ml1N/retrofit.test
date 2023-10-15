package com.ggr3ml1n.retrofittest.retrofit.api

import com.ggr3ml1n.retrofittest.retrofit.models.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Product
}