package com.example.newspark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsItemsClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager=LinearLayoutManager(this)
        val items=fetchData()
        val adapter= NewsListAdapter(items,this)

        //Now needed to link
        recyclerView.adapter=adapter
    }

    private fun fetchData():ArrayList<String>{
        val list=ArrayList<String>()
        for(i in 0 until 100){//addded 100 items//which says total 100 list will be there
            list.add("Item $i")
        }
        return list

    }

    override fun onItemclick(item: String) {
        Toast.makeText(this,"clicked item is $item", Toast.LENGTH_LONG).show()
    }
}