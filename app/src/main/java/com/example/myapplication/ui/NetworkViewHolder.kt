package com.example.myapplication.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.post_item.view.*

class NetworkViewHolder(
    override val containerView: View,
    private val action: ((String) -> Unit)?
) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    companion object {
        const val LAYOUT_ID = R.layout.post_item
    }

    fun bind(model: PostItem) {
        containerView.etComment.text
        containerView.setOnClickListener {
            action?.invoke(model.link)
        }
    }
}