package com.example.redditapp

import com.example.redditapp.models.Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.GET

interface Interface {
    @GET("top.json?limit=10")
    fun getContent(): Call<Json4Kotlin_Base>
}