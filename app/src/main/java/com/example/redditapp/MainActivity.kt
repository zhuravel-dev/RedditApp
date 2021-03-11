package com.example.redditapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsListView
import android.widget.OverScroller
import android.widget.ProgressBar
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.redditapp.adapter.Adapter
import com.example.redditapp.models.child.ChildDetails
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.core.view.isVisible as isVisible1


class MainActivity : AppCompatActivity(), DetailsClickListener {

    val adapter by lazy {
        Adapter().apply {
            clickLictener = this@MainActivity
        }
    }
    private var progressBar: ProgressBar? = null

    private var viewModel: MyViewModel? = null

    private var after: String? = null
    private var lastFetchedPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()

        progressBar = findViewById(R.id.progress_bar)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        observeLiveData()

        viewModel?.getAllData(DEFAULT_ITEMS_COUNT)
    }

    fun observeLiveData() {
        viewModel?.showProgress?.observe(this) { show ->
            progressBar?.isVisible1 = show
        }

        viewModel?.setData?.observe(this) { data ->
            after = data.data.after
            adapter.setData(data)
        }
    }


    fun setupRecyclerView() {
        val redditRecyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        redditRecyclerView.layoutManager = LinearLayoutManager(this)
        redditRecyclerView.adapter = this.adapter
        redditRecyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val manager = recyclerView.layoutManager as? LinearLayoutManager
                val lastPosition = manager?.findLastCompletelyVisibleItemPosition()?:0
                val lastPlusOne = lastPosition + 1
                if(lastPlusOne%DEFAULT_ITEMS_COUNT == 0 && lastPlusOne > lastFetchedPosition) {
                    Log.e("AA", "last position fetched $lastPosition")
                    viewModel?.getAllData(DEFAULT_ITEMS_COUNT, after)
                    lastFetchedPosition = lastPlusOne
                }
            }
        })
    }


    override fun onClick(children: ChildDetails) {
        Toast.makeText(this, "$children", LENGTH_LONG).show()
    }

    companion object {
        const val DEFAULT_ITEMS_COUNT = 10
    }
}



