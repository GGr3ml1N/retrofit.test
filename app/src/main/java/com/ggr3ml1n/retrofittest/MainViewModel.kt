package com.ggr3ml1n.retrofittest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ggr3ml1n.retrofittest.retrofit.api.MainApi
import com.ggr3ml1n.retrofittest.retrofit.models.AuthRequest
import com.ggr3ml1n.retrofittest.retrofit.models.User
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    private val _userLiveData = MutableLiveData<User>()
    val userLiveData: LiveData<User> = _userLiveData

    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val mainApi = retrofit.create(MainApi::class.java)

    fun getUser(username: String, password: String) {
        viewModelScope.launch {
            _userLiveData.value = mainApi.auth(
                AuthRequest(
                    username = username,
                    password = password
                )
            )
        }
    }
}