package com.example.myapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NetworkAdapter: RecyclerView.Adapter<NetworkViewHolder>() {

    var postList: List<PostItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var action: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NetworkViewHolder {
        return NetworkViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(NetworkViewHolder.LAYOUT_ID, parent, false),
            action
        )
    }

    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holder: NetworkViewHolder, position: Int) {
        holder.bind(postList[position])
    }
}