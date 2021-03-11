package com.example.redditapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redditapp.data.RetrofitClientInstance
import com.example.redditapp.models.Json4Kotlin_Base
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel: ViewModel() {

    private val _showProgress = MutableLiveData<Boolean>()
    val showProgress: LiveData<Boolean> = _showProgress

    private val _setData = MutableLiveData<Json4Kotlin_Base>()
    val setData: LiveData<Json4Kotlin_Base> = _setData


    fun getAllData(limit: Int, after: String? = null) {
        _showProgress.postValue(true)
        val service = RetrofitClientInstance.getRetrofit().create(Interface::class.java)
        val call: Call<Json4Kotlin_Base> = service.getContent(limit, after)
        call.enqueue(object : Callback<Json4Kotlin_Base> {
            override fun onResponse(
                call: Call<Json4Kotlin_Base>,
                response: Response<Json4Kotlin_Base>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) _setData.postValue(body)
                }
                _showProgress.postValue(false)
            }

            override fun onFailure(call: Call<Json4Kotlin_Base>, t: Throwable) {
                _showProgress.postValue(false)
            }
        })
    }
}