package com.example.mobileassignment.news


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.R
import com.example.mobileassignment.news.model.Article
import com.squareup.picasso.Picasso


class NewsAdapter(private val newsList : MutableList<Article>) :RecyclerView.Adapter<NewsHolder>() {
    private lateinit var context : Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        context = parent.context
        return NewsHolder(LayoutInflater.from(context).inflate(R.layout.news_layout_item,parent,false))
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val newsData = newsList[position]

        holder.newsTitle.text = newsData.title
        holder.newsAuthor.text = newsData.author
        holder.newsDesc.text = newsData.description
        Picasso.get()
            .load(newsData.urlToImage)
            .into(holder.newsImage)

        holder.itemView.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(newsData.url))
            context.startActivity(intent)
        }
    }








}

