package com.example.myapplication.ui.home.recycler

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.ui.home.model.Comment
import com.example.myapplication.ui.home.model.PostedItem
import com.example.myapplication.utils.DoubleClickListener
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.posted_item.view.*
import kotlinx.android.synthetic.main.posted_item.view.tvCommentTimeStamp

class PostedImageViewHolder(
    override val containerView: View,
    private val onLike: ((PostedItem) -> Unit)?,
    private val onProfile: ((PostedItem) -> Unit)?,
    private val onSendComment: ((PostedItem) -> Unit)?,
    private val onShare: ((PostedItem) -> Unit)?,
    private val onCommentAuthor: ((Comment) -> Unit)?

) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    companion object {
        const val LAYOUT_ID = R.layout.posted_item
    }

    var commentAdapter: CommentAdapter = CommentAdapter()

    fun bind(model: PostedItem) {
//        likesCount = if (model.isLiked) model.likesCount - 1 else model.likesCount + 1
        setLike(model.isLiked, model.likesCount)

        containerView.ivSendComment.setOnClickListener {
            containerView.rvComments.isVisible = true
            onSendComment?.invoke(
                model
            )
        }

        containerView.tvTopProfileName.text = model.profile.name
        containerView.tvTopProfileName.setOnClickListener {
            onProfile?.invoke(model)
        }

        Glide.with(containerView.context)
            .load(model.profile.photo)
            .into(containerView.civProfilePhoto)

        containerView.civProfilePhoto.setOnClickListener {
            onProfile?.invoke(model)
        }

        Glide.with(containerView.context)
            .load(model.imageUri)
            .into(containerView.ivPostPhoto)

        containerView.ivPostPhoto.setOnClickListener(object : DoubleClickListener() {
            override fun onDoubleClick(v: View) {
                onLike?.invoke(
                    model.copy(isLiked = !model.isLiked)
                )
            }
        })

//        containerView.llComments.addView()

        containerView.rvComments.apply {
            layoutManager = LinearLayoutManager(containerView.context, RecyclerView.VERTICAL, false)
            adapter = commentAdapter
        }

        commentAdapter.commentList = model.comments

        containerView.ivBottomIsLiked.setOnClickListener {
            onLike?.invoke(
                model.copy(isLiked = !model.isLiked)
            )
        }

        containerView.tvBottomProfileName.text = model.profile.name
        containerView.tvBottomProfileName.setOnClickListener {
            onProfile?.invoke(
                model
            )
        }
        containerView.tvPhotoDescription.text = model.title

        containerView.tvCommentTimeStamp.text = model.timeStamp

        containerView.ivShare.setOnClickListener {
            onShare?.invoke(
                model
            )
        }
    }


    fun setLike(like: Boolean, likesCount: Int) {
        if (like) {
            containerView.ivIsLiked.setImageResource(R.drawable.ic_red_like)
            containerView.ivBottomIsLiked.setImageResource(R.drawable.ic_red_like)
            containerView.tvLikeCounter.text = likesCount.toString()
        } else {
            containerView.ivIsLiked.setImageResource(R.drawable.ic_grey_like)
            containerView.ivBottomIsLiked.setImageResource(R.drawable.ic_grey_like)
            containerView.tvLikeCounter.text = likesCount.toString()
        }
    }
}