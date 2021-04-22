package com.example.myapplication.ui.home.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ui.home.model.Comment
import com.example.myapplication.ui.home.model.PostedItem

class PostedImageAdapter : RecyclerView.Adapter<PostedImageViewHolder>() {

    var postList: List<PostedItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onLikeClick: ((PostedItem) -> Unit)? = null
    var onProfileClick: ((PostedItem) -> Unit)? = null
    var onSendCommentClick: ((PostedItem) -> Unit)? = null
    var onShareClick: ((PostedItem) -> Unit)? = null
    var onCommentAuthorClick: ((Comment) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostedImageViewHolder {
        return PostedImageViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    PostedImageViewHolder.LAYOUT_ID,
                    parent,
                    false
                ),
            onLikeClick,
            onProfileClick,
            onSendCommentClick,
            onShareClick,
            onCommentAuthorClick
        )
    }

    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holder: PostedImageViewHolder, position: Int) {
        holder.bind(postList[position])
    }
}