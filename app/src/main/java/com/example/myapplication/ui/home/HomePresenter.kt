package com.example.myapplication.ui.home

import android.content.Context
import android.widget.Toast
import com.example.myapplication.ui.home.model.Comment
import com.example.myapplication.ui.home.model.PostedItem
import com.example.myapplication.ui.home.model.UserProfile
import kotlin.coroutines.coroutineContext

class HomePresenter(private val view: HomeContract.View) :
    HomeContract.Presenter {

    var listOfData = mutableListOf(
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
                        photo = "https://www.thispersondoesnotexist.com/image?21603152692"
                    ),
                    description = "nice",
                    commentTimeStamp = "12:32"
                ),
                Comment(
                    profile = UserProfile(
                        id = "1242",
                        name = "Random woman",
                        photo = "https://www.thispersondoesnotexist.com/image?21603152693"
                    ),
                    description = "nice",
                    commentTimeStamp = "12:32"
                ),
                Comment(
                    profile = UserProfile(
                        id = "321",
                        name = "Random man",
                        photo = "https://www.thispersondoesnotexist.com/image?21603152694"
                    ),
                    description = "nice",
                    commentTimeStamp = "12:32"
                )
            )
        ), PostedItem(
            profile = UserProfile(
                id = "321",
                name = "Random Human ",
                photo = "https://www.thispersondoesnotexist.com/image?21603152698"
            ),
            imageUri = "https://www.thispersondoesnotexist.com/image?21603152749",
            likesCount = 1,
            isLiked = false,
            postId = "sgsdhf1",
            timeStamp = "123 years ago",
            title = "nice photo",
            comments = listOf(
                Comment(
                    profile = UserProfile(
                        id = "123",
                        name = "Random Human",
                        photo = "https://www.thispersondoesnotexist.com/image?21603152692"
                    ),
                    description = "nice",
                    commentTimeStamp = "12:32"
                ),
                Comment(
                    profile = UserProfile(
                        id = "124",
                        name = "Random woman",
                        photo = "https://www.thispersondoesnotexist.com/image?21603152693"
                    ),
                    description = "nice",
                    commentTimeStamp = "12:32"
                ),
                Comment(
                    profile = UserProfile(
                        id = "321",
                        name = "Random man",
                        photo = "https://www.thispersondoesnotexist.com/image?21603152694"
                    ),
                    description = "nice",
                    commentTimeStamp = "12:32"
                )
            )
        )
    )

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

    override fun onAuthorProfileClick() {
        TODO("Not yet implemented")
    }

    private fun uploadData(): List<PostedItem> {
        return listOfData
    }

    override fun onLikeClick(item: PostedItem) {
        val index = listOfData.indexOfFirst { it.postId == item.postId }
        if (index != -1) {
            listOfData[index] =
                item.copy(
                    likesCount = if (item.isLiked) item.likesCount - 1 else item.likesCount + 1,
                    isLiked = !item.isLiked
                )
        }
        view.setItems(listOfData)
    }

    override fun onProfileClick(item: PostedItem) {
        TODO("Not yet implemented")
    }

    override fun onSendCommentClick(item: PostedItem) {
        TODO("Not yet implemented")
    }

    override fun onShareClick(item: PostedItem) {
        TODO("Not yet implemented")
    }

    override fun onCommentAuthorClick(item: Comment) {
        TODO("Not yet implemented")
    }
}