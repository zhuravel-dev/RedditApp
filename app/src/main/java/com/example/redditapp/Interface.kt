package com.example.redditapp

import Json4KotlinBase
import retrofit2.Call
import retrofit2.http.GET

interface Interface {
    @get:GET("/response")
    val content: Call<Json4KotlinBase>
}