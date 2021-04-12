package com.example.myapplication.ui.home.recycler

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.ui.home.model.PostedItem
import com.example.myapplication.utils.DoubleClickListener
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

    var isLiked: Boolean = false

    fun setLike(like: Boolean) {
        if (like) {
            containerView.ivIsLiked.setImageResource(R.drawable.ic_red_like)
            containerView.ivBottomIsLiked.setImageResource(R.drawable.ic_red_like)
        } else {
            containerView.ivIsLiked.setImageResource(R.drawable.ic_grey_like)
            containerView.ivBottomIsLiked.setImageResource(R.drawable.ic_grey_like)
        }
        isLiked = !isLiked
    }

    fun bind(model: PostedItem) {

        isLiked = model.isLiked

        containerView.tvTopProfileName.text = model.profile.name
        containerView.tvTopProfileName.setOnClickListener {
            action?.invoke(model.profile.id)
        }

        Glide.with(containerView.context)
            .load(model.profile.photo)
            .into(containerView.civProfilePhoto)

        containerView.civProfilePhoto.setOnClickListener {
            action?.invoke(model.profile.id)
        }

        Glide.with(containerView.context)
            .load(model.imageUri)
            .into(containerView.ivPostPhoto)

        containerView.ivPostPhoto.setOnClickListener(object : DoubleClickListener() {
            override fun onDoubleClick(v: View) {
                setLike(isLiked)
//                isLiked = !isLiked
                Toast.makeText(containerView.context, "rabotaet", Toast.LENGTH_SHORT).show()
            }
        })


//        containerView.ivIsLiked.
//        containerView.etAddComment.setOnClickListener {
//            action?.
//        }

//        containerView.ivShare.setOnClickListener {
//            action?.
//        }

        containerView.ivBottomIsLiked.setOnClickListener {
            setLike(isLiked)
//            isLiked = !isLiked
        }

        containerView.tvLikeCounter.text = model.likesCount.toString()

        containerView.tvBottomProfileName.text = model.profile.name
        containerView.tvBottomProfileName.setOnClickListener {
            action?.invoke(model.profile.id)
        }
        containerView.tvPhotoDescription.text = model.title

        containerView.tvTimeStamp.text = model.timeStamp
    }
}