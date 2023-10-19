package com.ggr3ml1n.retrofittest.retrofit.models

data class User(
    val id: Int,
    val userName: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    val token: String,
)