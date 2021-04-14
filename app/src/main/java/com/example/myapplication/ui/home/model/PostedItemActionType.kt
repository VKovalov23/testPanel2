package com.example.myapplication.ui.home.model

sealed class PostedItemActionType {
    data class Like(val isLiked: Boolean) : PostedItemActionType()

    data class ProfileId(val id: String) : PostedItemActionType()

    data class Comment(val title: String, val postId: String, val timeStamp: String) :
        PostedItemActionType()

    data class Share(val postId: String) : PostedItemActionType()
}