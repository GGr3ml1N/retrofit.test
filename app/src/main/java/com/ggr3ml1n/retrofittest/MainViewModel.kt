package com.ggr3ml1n.retrofittest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ggr3ml1n.retrofittest.retrofit.api.ProductApi
import com.ggr3ml1n.retrofittest.retrofit.models.Product
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel: ViewModel() {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val productApi = retrofit.create(ProductApi::class.java)

    private val _productLiveData = MutableLiveData<Product>()
    val productLiveData: LiveData<Product> = _productLiveData

    fun initialize() {
        viewModelScope.launch {
            _productLiveData.value = productApi.getProductById(1)
        }
    }
}