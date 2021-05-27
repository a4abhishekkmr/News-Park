package com.example.newspark

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class NewsListAdapter: RecyclerView.Adapter<> {
}

class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    val titleview: TextView = itemView.findViewById(R.id.titlee)
}