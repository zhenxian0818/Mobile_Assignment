package com.example.mobileassignment.news.Common

import com.example.mobileassignment.news.Interface.NewsService
import com.example.mobileassignment.news.Remote.RetrofitClient

object Common {
    val BASE_URL = "https://newsapi.org/v2/everything?q=climatechange&apiKey=72b5b594568d489f815624b4856d570d"
    val API_KEY = "72b5b594568d489f815624b4856d570d"

    val newsService: NewsService
        get()= RetrofitClient.getClient(BASE_URL).create(NewsService::class.java)

}