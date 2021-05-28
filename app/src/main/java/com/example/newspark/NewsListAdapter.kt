package com.example.newspark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsListAdapter(val items:ArrayList<String>,private val listener:NewsItemsClicked): RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        //Layout inflator added
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
            //added item_news.xml as a view to be used
        //which  is passed below.
        //adding onclick
        val viewHolder=NewsViewHolder(view)
        view.setOnClickListener {
            listener.onItemclick(items[viewHolder.adapterPosition])
        }

        return viewHolder
        //Needed instance of NewsViewHolder
    }

    override fun onBindViewHolder(holder:NewsViewHolder, position: Int) {
            //binds data
        //position to bind
        val currentItem= items[position]
        holder.titleview.text=currentItem
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    val titleview: TextView = itemView.findViewById(R.id.titlee)
}

//Added a callback
//that tells that something is called here onclick listener
//Added a interface for callback
interface NewsItemsClicked{
    fun onItemclick(item: String)
}
