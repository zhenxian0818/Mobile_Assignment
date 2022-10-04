package com.example.mobileassignment.news.model


import com.google.gson.annotations.SerializedName

data class Reqres(
    @SerializedName("articles")
    val articles: List<Article>
)