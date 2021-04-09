package com.example.myapplication.ui.home.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.ui.home.model.PostedItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.posted_item.view.*

class PostedImageViewHolder(
    override val containerView: View,
    private val action: ((String) -> Unit)?
) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    companion object {
        const val LAYOUT_ID = R.layout.posted_item
    }

    fun bind(model: PostedItem) {
        containerView.tvTopProfileName.text = model.profile.profileName
        containerView.tvTopProfileName.setOnClickListener {
            action?.invoke(model.profile.profileLink)
        }

        Glide.with(containerView.context)
            .load(model.profile.profilePhoto)
            .into(containerView.civProfilePhoto)
        containerView.civProfilePhoto.setOnClickListener {
            action?.invoke(model.profile.profileLink)
        }

        Glide.with(containerView.context)
            .load(model.imageUri)
            .into(containerView.ivPostPhoto)

//        containerView.ivIsLiked.
//        containerView.etAddComment.setOnClickListener {
//            action?.
//        }

//        containerView.ivShare.setOnClickListener {
//            action?.
//        }

//        containerView.ivBottomIsLiked

        containerView.tvLikeCounter.text = model.likesCount.toString()

        containerView.tvBottomProfileName.text = model.profile.profileName
        containerView.tvBottomProfileName.setOnClickListener {
            action?.invoke(model.profile.profileLink)
        }
        containerView.tvPhotoDescription.text = model.title

        containerView.tvTimeStamp.text = model.timeStamp
    }
}