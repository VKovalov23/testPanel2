package com.example.myapplication.ui.home.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
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
//        containerView.etComment.text
//        containerView.setOnClickListener {
//            action?.invoke(model.profile)
//        }
    }
}