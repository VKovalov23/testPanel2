package com.example.myapplication.ui.home.model

data class PostedItem(
    val profile: UserProfile,
    val imageUri: String,
    val comments: List<Comment>,
    val likesCount: Int,
    val isLiked: Boolean,
    val timeStamp: String,
    val title: String
)

data class UserProfile(
    val photoUri: String,
    val profileLink: String,
    val profileName: String,
    val profilePhoto: String
)

data class Comment(
    val profile: UserProfile,
    val description: String,
    val commentTimeStamp: String
)