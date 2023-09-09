package com.plcoding.weatherapp.domain.repository

import ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("your_api_endpoint_here")
    fun fetchData(): Call<ApiResponse>
}