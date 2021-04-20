package com.example.myapplication.ui.home.recycler

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.ui.home.model.PostedItem
import com.example.myapplication.ui.home.model.PostedItemActionType
import com.example.myapplication.utils.DoubleClickListener
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.posted_item.view.*
import kotlinx.android.synthetic.main.posted_item.view.tvCommentTimeStamp

class PostedImageViewHolder(
    override val containerView: View,
    private val action: ((PostedItemActionType) -> Unit)?
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

            action?.invoke(
                PostedItemActionType.Comment(
                    model.postId,
                    containerView.etAddComment.text.toString(),
                    System.currentTimeMillis().toString()
                ) as PostedItemActionType
            )
        }

        containerView.tvTopProfileName.text = model.profile.name
        containerView.tvTopProfileName.setOnClickListener {
            action?.invoke(PostedItemActionType.ProfileId(model.profile.id) as PostedItemActionType)
        }

        Glide.with(containerView.context)
            .load(model.profile.photo)
            .into(containerView.civProfilePhoto)

        containerView.civProfilePhoto.setOnClickListener {
            action?.invoke(PostedItemActionType.ProfileId(model.profile.id) as PostedItemActionType)
        }

        Glide.with(containerView.context)
            .load(model.imageUri)
            .into(containerView.ivPostPhoto)

        containerView.ivPostPhoto.setOnClickListener(object : DoubleClickListener() {
            override fun onDoubleClick(v: View) {
                action?.invoke(
                    PostedItemActionType.Like(
                        model.isLiked,
                        model.postId
                    ) as PostedItemActionType
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
            action?.invoke(
                PostedItemActionType.Like(
                    model.isLiked,
                    model.postId
                ) as PostedItemActionType
            )
        }

        containerView.tvBottomProfileName.text = model.profile.name
        containerView.tvBottomProfileName.setOnClickListener {
            action?.invoke(PostedItemActionType.ProfileId(model.profile.id) as PostedItemActionType)
        }
        containerView.tvPhotoDescription.text = model.title

        containerView.tvCommentTimeStamp.text = model.timeStamp

        containerView.ivShare.setOnClickListener {
            action?.invoke(PostedItemActionType.Share(model.postId) as PostedItemActionType)
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