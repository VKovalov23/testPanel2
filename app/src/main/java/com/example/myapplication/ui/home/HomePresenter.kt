package com.example.myapplication.ui.home

import com.example.myapplication.ui.home.model.Comment
import com.example.myapplication.ui.home.model.PostedItem
import com.example.myapplication.ui.home.model.PostedItemActionType
import com.example.myapplication.ui.home.model.UserProfile

class HomePresenter(private val view: HomeContract.View) :
    HomeContract.Presenter {

    override fun init() {
        view.initView()
        view.setItems(uploadData())
    }

    override fun onLogoClick() {
        TODO("Not yet implemented")
    }

    override fun onCameraClick() {
        TODO("Not yet implemented")
    }

    override fun onMenuClick() {
        TODO("Not yet implemented")
    }

    override fun onItemClick() {
        TODO("Not yet implemented")
    }

    override fun onCommentClick() {
        TODO("Not yet implemented")
    }

    override fun onAuthorProfileClick(profileId: PostedItemActionType) {
        when (profileId) {
            is PostedItemActionType.ProfileId-> {}
            is PostedItemActionType.Like-> {}
            is PostedItemActionType.Comment-> {}
            is PostedItemActionType.Share-> {}
        }
    }

    private fun uploadData(): List<PostedItem> {
        return listOf(
            PostedItem(
                profile = UserProfile(
                    id = "123",
                    name = "Random Human ",
                    photo = "https://www.thispersondoesnotexist.com/image?21603152698"
                ),
                imageUri = "https://www.thispersondoesnotexist.com/image?21603152698",
                likesCount = 1,
                isLiked = true,
                postId = "sgsdhf",
                timeStamp = "123 years ago",
                title = "nice photo",
                comments = listOf(
                    Comment(
                        profile = UserProfile(
                            id = "123",
                            name = "Random Human",
                            photo = "https://www.thispersondoesnotexist.com/image?21603152698"
                        ),
                        description = "nice",
                        commentTimeStamp = "12:32"

                    )
                )
            )
        )
    }

    override fun onLogOutClick() {
        TODO("Not yet implemented")
    }
}