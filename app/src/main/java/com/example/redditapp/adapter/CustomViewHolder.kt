package com.example.redditapp.adapter

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.icu.text.SimpleDateFormat
import android.icu.util.TimeUnit
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.redditapp.DetailsClickListener
import com.example.redditapp.R
import com.example.redditapp.models.child.ChildDetails
//import com.squareup.picasso.Picasso
import java.net.MalformedURLException
import java.net.URL
import java.util.*
import java.util.concurrent.Executors


class CustomViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val uiHandler = Handler(Looper.getMainLooper())
    private val executor = Executors.newSingleThreadExecutor()

    @SuppressLint("NewApi", "SimpleDateFormat")
    fun bind(children: ChildDetails, clickLictener: DetailsClickListener?) {
        val imageView = itemView.findViewById<ImageView>(R.id.image)
        val titleView = itemView.findViewById<TextView>(R.id.title)
        val authorView = itemView.findViewById<TextView>(R.id.author)
        val commentsView = itemView.findViewById<TextView>(R.id.comments)
        val hoursView = itemView.findViewById<TextView>(R.id.hours)


            val sdf = SimpleDateFormat("dd.MM.yy hh:mm")
            val netDate = Date((children.data.created_utc)*1000)
            val date = sdf.format(netDate)

            Log.e("Tag", "Formatted Date$date")


        
        titleView.setText(children.data.title)
        setImage(children.data.thumbnail, imageView)
        authorView.setText(children.data.author)
        commentsView.setText("comments: ${children.data.num_comments}")
        hoursView.setText(date)



        itemView.setOnClickListener {
            clickLictener?.onClick(children)
        }
    }

    private fun setImage(link: String, imageView: ImageView) {
        try {
            val url = URL(link)
             executor.submit {
                     val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
                     uiHandler.post { imageView.setImageBitmap(bmp) }
             }.get()
        } catch (ex: MalformedURLException) {
            Log.e(CustomViewHolder::class.java.simpleName, ex.localizedMessage.orEmpty())
        }
    }
}
