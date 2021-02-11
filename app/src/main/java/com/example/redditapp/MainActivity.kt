package com.example.redditapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.redditapp.adapter.Adapter
import com.example.redditapp.data.RetrofitClientInstance
import com.example.redditapp.models.Json4Kotlin_Base
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.core.view.isVisible as isVisible1


class MainActivity : AppCompatActivity() {

    val adapter = Adapter()
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        getAllData()
        progressBar = findViewById(R.id.progress_bar)
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = this.adapter
    }

    private fun getAllData() {
        progressBar?.isVisible1 = true
        val service = RetrofitClientInstance.getRetrofit().create(Interface::class.java)
        val call: Call<Json4Kotlin_Base> = service.getContent()
        call.enqueue(object : Callback<Json4Kotlin_Base> {
            override fun onResponse(
                call: Call<Json4Kotlin_Base>,
                response: Response<Json4Kotlin_Base>
            ) {
                if(response.isSuccessful) {
                    val body = response.body()
                    if(body != null) adapter.setData(body)

                }
                progressBar?.isVisible1 = false
            }

            override fun onFailure(call: Call<Json4Kotlin_Base>, t: Throwable) {
                progressBar?.isVisible1 = false
            }
        })
    }
}