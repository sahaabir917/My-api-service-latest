package com.example.marsapi

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AnotherApiService {

    @GET("posts")
    fun fetchAlltypes(@Query("id") id : Int): Call<List<Typedata>>

    @POST("posts")
    fun senddatatypes(@Body newTypedata: Typedata) : Call<Typedata>
}