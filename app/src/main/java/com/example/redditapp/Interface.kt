package com.example.redditapp

import com.example.redditapp.models.Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Interface {
    @GET("top.json")
    fun getContent(
        @Query("limit") limit: Int = 10,
        @Query("after") after: String? = null,
    ): Call<Json4Kotlin_Base>
}