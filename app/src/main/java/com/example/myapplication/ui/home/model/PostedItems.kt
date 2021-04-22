package com.example.myapplication.ui.home.model

data class PostedItem(
    val profile: UserProfile,
    val imageUri: String,
    val comments: List<Comment>,
    val likesCount: Int,
    val isLiked: Boolean,
    val timeStamp: String,
    val title: String,
    val postId: String
)

data class UserProfile(
    val id: String,
    val name: String,
    val photo: String
)

data class Comment(
    val profile: UserProfile,
    val description: String,
    val commentTimeStamp: String
)