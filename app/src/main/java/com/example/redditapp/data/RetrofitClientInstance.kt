package com.example.redditapp.data

import retrofit.GsonConverterFactory
import retrofit2.Retrofit

object RetrofitClientInstance {

    val baseUrl = "https://www.reddit.com/top.json?limit=10"

    fun getRetrofit () = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

