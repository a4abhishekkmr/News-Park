package com.example.newspark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsItemsClicked {

    private lateinit var madapter:NewsListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager=LinearLayoutManager(this)
        val items=fetchData()
        val madapter= NewsListAdapter(this)

        //Now needed to link
        recyclerView.adapter=madapter
    }

    private fun fetchData():{
       val url= "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=32c647cb10f74ab18ebc263c8a910e4c"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener{
                val newsJsonArray = it.getJSONArray("articles")
                val NewsArray=ArrayList<News>()
                ///to iterate one by one
                for(i in 0 until newsJsonArray.length()) {
                    val newsJsonObject = newsJsonArray.getJSONObject(i)
                    val news=News(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("author"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToimage")

                    )
                    newsArray.add(news)
                }
                madapter.updateNews(newsArray)
            },
            Response.ErrorListener {

            }
        )
    }

}

    override fun onItemclick(item: News) {

    }
}