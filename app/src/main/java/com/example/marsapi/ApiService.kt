package com.example.marsapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("realestate")
    fun fetchAllusers(): Call<List<Marsdata>>
}