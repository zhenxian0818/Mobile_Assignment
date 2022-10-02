package com.example.mobileassignment.news


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobileassignment.News
import com.example.mobileassignment.R


class NewsAdapter(private val newsList : List<News.Post>, private val listener: NewsAdapter.OnItemClickListener) :RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View)
        : RecyclerView.ViewHolder(view), View.OnClickListener{

        val newsTitle: TextView = view.findViewById(R.id.newsTitle)
        val newsAuthor: TextView = view.findViewById(R.id.newsAuthor)
        val newsDesc: TextView = view.findViewById(R.id.newsDesc)
        val newsImage: ImageView = view.findViewById(R.id.newsImage)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = bindingAdapterPosition
            if(position != RecyclerView.NO_POSITION){
                listener.itemClick(position)
            }
        }
    }
    interface OnItemClickListener{
        fun itemClick(position: Int)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentNews = newsList[position]

        holder.newsTitle.text = currentNews.title
        holder.newsAuthor.text = currentNews.author
        holder.newsDesc.text = currentNews.description
        Glide.with(holder.itemView).load(currentNews.urlToImage).into(holder.newsImage);


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.news_layout_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

}

