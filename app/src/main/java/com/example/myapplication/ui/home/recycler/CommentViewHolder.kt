package com.example.myapplication.ui.home.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.ui.home.model.Comment
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.comment_item.view.*

class CommentViewHolder(
    override val containerView: View,
    private val onCommentAuthorClick: ((Comment) -> Unit)?
) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    companion object {
        const val LAYOUT_ID = R.layout.comment_item
    }

    fun bind(model: Comment) {
        containerView.tvProfileName.text = model.profile.name
        containerView.tvProfileName.setOnClickListener {
            onCommentAuthorClick?.invoke(model)
        }

        containerView.tvCommentTitle.text = model.description

        containerView.tvCommentTimeStamp.text = model.commentTimeStamp
    }
}