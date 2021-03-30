package com.example.myapplication.ui.home.model

data class PostedItem(
    val profile: UserProfile,
    val imageUri: String,
    val commentsList: List<Comment>,
    val likesCount: Int,
    val isLiked: Boolean,
    val timeStamp: String,
    val imageDescription: String
)

data class UserProfile(
    val photoUri: String,
    val profileLink: String,
    val name: String
)

data class Comment(
    val profile: UserProfile,
    val description: String
)