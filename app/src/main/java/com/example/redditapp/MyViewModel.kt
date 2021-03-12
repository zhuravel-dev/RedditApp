package com.example.redditapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redditapp.data.RetrofitClientInstance
import com.example.redditapp.models.Json4Kotlin_Base
import com.example.redditapp.models.child.ChildDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel: ViewModel() {

    private val _showProgress = MutableLiveData<Boolean>()
    val showProgress: LiveData<Boolean> = _showProgress

    private val _setData = MutableLiveData<List<ChildDetails>>()
    val setData: LiveData<List<ChildDetails>> = _setData

    private val _after = MutableLiveData<String>()
    val after: LiveData<String> = _after


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
                    val body: Json4Kotlin_Base? = response.body()
                    if (body != null) {
                        val children = body.data.children
                        _after.postValue(body.data.after)
                        _setData.postValue(children)
                    }
                }
                _showProgress.postValue(false)
            }

            override fun onFailure(call: Call<Json4Kotlin_Base>, t: Throwable) {
                _showProgress.postValue(false)
            }
        })
    }
}