package com.example.mobileassignment.news

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R
import com.example.mobileassignment.news.Interface.ItemClickListener


class NewsListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener {

    val newsHead:TextView = itemView.findViewById(R.id.newsTitle)
    //val newsContent:TextView = itemView.findViewById(R.id.news)
    //val newsAuthor:TextView = itemView.findViewById(R.id.newsAuthor)
    val newsImage:ImageView = itemView.findViewById(R.id.newsImage)

    private lateinit var itemClickListener: ItemClickListener

    var source_title = newsHead

    fun setItemClickListener(itemClickListener: ItemClickListener){
        this.itemClickListener = itemClickListener
    }

    override fun onClick(v: View?) {
        itemClickListener.onClick(v!!,absoluteAdapterPosition)
    }
}