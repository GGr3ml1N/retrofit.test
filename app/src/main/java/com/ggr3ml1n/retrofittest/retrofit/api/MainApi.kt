package com.ggr3ml1n.retrofittest.retrofit.api

import com.ggr3ml1n.retrofittest.retrofit.models.AuthRequest
import com.ggr3ml1n.retrofittest.retrofit.models.User
import retrofit2.http.Body
import retrofit2.http.POST

interface MainApi {
    @POST("auth/login")
    suspend fun auth(@Body authRequest: AuthRequest): User
}