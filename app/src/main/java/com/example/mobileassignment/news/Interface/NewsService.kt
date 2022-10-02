package com.example.mobileassignment.news.Interface


import com.example.mobileassignment.news.model.WebSite
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @get:GET("v2/everything?q=climatechange&apiKey=72b5b594568d489f815624b4856d570d")
    val sources: Call<WebSite>
}