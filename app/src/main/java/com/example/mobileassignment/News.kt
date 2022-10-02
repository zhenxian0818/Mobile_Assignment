package com.example.mobileassignment

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileassignment.databinding.ActivityNewsBinding
import com.example.mobileassignment.news.Interface.NewsService
import com.example.mobileassignment.news.NewsAdapter
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.reflect.Type

class News : AppCompatActivity(), NewsAdapter.OnItemClickListener {
    private lateinit var binding: ActivityNewsBinding

    class Post(
        var id: String = "",
        var name: String = "",
        var author: String = "",
        var title: String = "",
        var description: String = "",
        var url: String = "",
        var urlToImage: String = "",
        var PublishedAt: String = "",
        var content: String = ""
    )

    lateinit var layoutManager: LinearLayoutManager
    lateinit var mService: NewsService
    lateinit var adapter: NewsAdapter
    lateinit var dialog: AlertDialog
    private val newsListOf = listOf<Post>(
        Post(
            "id1",
            "name1",
            "John",
            "Title News1",
            "Desc 1",
            "null",
            "https://cdn.discordapp.com/attachments/370576610056732684/1026022824961384518/unknown.png",
            "Sea",
            "context 1"
        ),
        Post(
            "id2",
            "name2",
            "Jayne",
            "Title News2",
            "Desc 2",
            "null",
            "https://cdn.discordpp.com/attachments/370576610056732684/1026022824961384518/unknown.png",
            "Sea",
            "context 2"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate((layoutInflater))
        setContentView(binding.root)

        val moshi: Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val httpAsync =
            "https://newsapi.org/v2/everything?q=climatechange&apiKey=72b5b594568d489f815624b4856d570d"
                .httpGet()
                .responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val ex = result.getException()
                            println(ex)
                        }
                        is Result.Success -> {
                            val data = result.get()
                            println(data)

                            val type: Type =
                                Types.newParameterizedType(List::class.java, Post::class.java)
                            val adapter: JsonAdapter<List<Post>> = moshi.adapter(type)
                            val posts: List<Post>? = adapter.fromJson(data)

                            for (post in posts!!) {
                                println(post)
                            }
                        }
                    }

                }
        httpAsync.join()

        val recyclerSourceNews: RecyclerView = findViewById(R.id.recyclerSourceNews)

        val adapter = NewsAdapter(newsListOf, this)
        binding.recyclerSourceNews.adapter = adapter

        layoutManager = LinearLayoutManager(this)
        binding.recyclerSourceNews.layoutManager = LinearLayoutManager(this)


    }

    override fun itemClick(position: Int) {
        TODO("Not yet implemented")
    }


}
