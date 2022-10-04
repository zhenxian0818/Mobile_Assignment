package com.example.mobileassignment.news

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R

class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val newsTitle: TextView = itemView.findViewById(R.id.newsTitle)
        val newsAuthor: TextView = itemView.findViewById(R.id.newsAuthor)
        val newsDesc: TextView = itemView.findViewById(R.id.newsDesc)
        val newsImage: ImageView = itemView.findViewById(R.id.newsImage)

    }
