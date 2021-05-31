package com.example.newspark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsListAdapter(private val listener:NewsItemsClicked): RecyclerView.Adapter<NewsViewHolder>() {

    private val items:ArrayList<News> = ArrayList()
//adapter dos'nt bother about data from where it is coming.
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
        holder.titleview.text=currentItem.title
        holder.author.text=currentItem.author
        Glide.with(holder.itemView.context).load(currentItem.urlToImage).into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateNews(updatedNews: ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }
}

class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    val titleview: TextView = itemView.findViewById(R.id.title)
    val image: ImageView=itemView.findViewById(R.id.image)
    val author: TextView=itemView.findViewById(R.id.author)
}

//Added a callback
//that tells that something is called here onclick listener
//Added a interface for callback
interface NewsItemsClicked{
    fun onItemclick(item: News)
}
