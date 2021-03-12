package com.example.redditapp.adapter

//import com.squareup.picasso.Picasso
import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.icu.text.RelativeDateTimeFormatter
import android.icu.text.SimpleDateFormat
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
import java.net.MalformedURLException
import java.net.URL
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


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
        val postMillis = children.data.created_utc * 1000
        hoursView.text = getTimeText(postMillis)
        titleView.text = children.data.title
        setImage(children.data.thumbnail, imageView)
        authorView.text = children.data.author
        val commentsCount = "comments: ${children.data.num_comments}"
        commentsView.text = commentsCount
        itemView.setOnClickListener {
            clickLictener?.onClick(children)
        }
    }

    private fun getTimeText(postTimeMillis: Long): String {
        val context = itemView.context
        val dateNow = Date().time
        return if (dateNow > postTimeMillis){
            val hours = TimeUnit.MILLISECONDS.toHours(dateNow - postTimeMillis)
            val hoursAgo = context.getString(R.string.hours_ago)
            "$hours $hoursAgo"
        } else context.getString(R.string.just_now)
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
