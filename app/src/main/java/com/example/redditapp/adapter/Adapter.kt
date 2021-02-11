package com.example.redditapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.redditapp.R
import com.example.redditapp.models.Json4Kotlin_Base
import com.example.redditapp.models.child.ChildDetails

class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var redditPostsList : MutableList<ChildDetails> = mutableListOf()

    fun setData(response: Json4Kotlin_Base) {
        redditPostsList.clear()
        redditPostsList.addAll(response.data.children)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.custom_row, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.e("Adapter", "bind holder with position $position")
        (holder as? CustomViewHolder)?.bind(redditPostsList.get(position))
    }

    override fun getItemCount(): Int = redditPostsList.size
}