package com.example.redditapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.redditapp.DetailsClickListener
import com.example.redditapp.R
import com.example.redditapp.models.Json4Kotlin_Base
import com.example.redditapp.models.child.ChildDetails

class Adapter : RecyclerView.Adapter<CustomViewHolder>() {

    private var redditPostsList : MutableList<ChildDetails> = mutableListOf()
    var clickLictener: DetailsClickListener? = null

    fun setData(response: Json4Kotlin_Base) {
        redditPostsList.addAll(response.data.children)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.custom_row, parent, false)
        return CustomViewHolder(view)

        }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        Log.e("Adapter", "bind holder with position $position")
        (holder as? CustomViewHolder)?.bind(redditPostsList[position], clickLictener)

       }

    override fun getItemCount(): Int = redditPostsList.size


  }
