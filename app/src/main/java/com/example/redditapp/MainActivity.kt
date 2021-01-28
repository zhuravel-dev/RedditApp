package com.example.redditapp

import Json4KotlinBase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.redditapp.data.RetrofitClientInstance
import com.squareup.okhttp.Call
import com.squareup.okhttp.Callback


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    var service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService::class.java){
        var Json4KotlinBase: Call
        var call = service.getAllPhotos()
        call.enqueue(Callback<Json4KotlinBase>())
    }




}