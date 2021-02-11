package com.example.redditapp.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.redditapp.R
import com.example.redditapp.models.child.ChildDetails
import com.squareup.picasso.Picasso


class CustomViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(children: ChildDetails) {
                val image = itemView.findViewById<ImageView>(R.id.image)
                val txt = itemView.findViewById<TextView>(R.id.text)
                txt.setText(children.data.title)
                Picasso.Builder(view.context).build().load(children.data.thumbnail).into(image)
        }
}
