package com.example.mobileassignment

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.mobileassignment.news.NewsAdapter
import com.example.mobileassignment.news.model.Article
import com.example.mobileassignment.news.model.Reqres

class News : AppCompatActivity() {

    private var newsDataList: MutableList<Article> = mutableListOf()
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        val recyclerSourceNews: RecyclerView = findViewById(R.id.recyclerSourceNews)

        //setup adapter
        adapter = NewsAdapter(newsDataList)

        //setup recylcerview
        recyclerSourceNews.layoutManager = LinearLayoutManager(this)
        recyclerSourceNews.adapter = adapter


        //var newsDataList : List<NewsSource> = listOf()
        AndroidNetworking.initialize(this)
        AndroidNetworking.get("https://newsapi.org/v2/everything?q=globalwarming&apiKey=72b5b594568d489f815624b4856d570d")
            .build()
            .getAsObject(Reqres::class.java, object : ParsedRequestListener<Reqres> {
                override fun onResponse(response: Reqres) {
                    newsDataList.addAll(response.articles)
                    adapter.notifyDataSetChanged()
                }

                override fun onError(anError: ANError?) {
                    Toast.makeText(applicationContext, "Data Retrieval Error ", LENGTH_SHORT).show()
                }
            })
    }
}

