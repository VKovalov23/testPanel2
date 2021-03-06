package com.example.myapplication.ui.home.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ui.home.model.Comment

class CommentAdapter : RecyclerView.Adapter<CommentViewHolder>() {

    var commentList: List<Comment> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onCommentAuthorClick: ((Comment) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    CommentViewHolder.LAYOUT_ID,
                    parent,
                    false
                ),
            onCommentAuthorClick
        )
    }

    override fun getItemCount(): Int = commentList.size

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(commentList[position])
    }
}