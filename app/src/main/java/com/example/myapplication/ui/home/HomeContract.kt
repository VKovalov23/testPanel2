package com.example.myapplication.ui.home

import com.example.myapplication.ui.home.model.PostedItem
import com.example.myapplication.utils.core.ui.BaseContract

interface HomeContract {

    interface View : BaseContract.View {
        fun initView()
        fun setItems(items: List<PostedItem>)
        fun updateItem()
    }

    interface Presenter : BaseContract.Presenter {
        fun init()
        fun onLogoClick()
        fun onCameraClick()
        fun onMenuClick()
        fun onItemClick()
        fun onCommentClick()
        fun onAuthorProfileClick()

        fun onLikeClick(isLiked: Boolean, postId: String)
        fun onProfileClick(id: String)
        fun onSendCommentClick(title: String, postId: String)
        fun onShareClick(postId: String)
        fun onCommentAuthorClick(id: String)

    }
}