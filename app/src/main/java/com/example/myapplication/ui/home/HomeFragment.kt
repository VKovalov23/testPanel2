package com.example.myapplication.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.ui.home.model.Comment
import com.example.myapplication.ui.home.model.PostedItem
import com.example.myapplication.ui.home.model.UserProfile
import com.example.myapplication.ui.home.recycler.PostedImageAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment()
        const val IDENT = "HomeFragment"
    }

    var postedImageAdapter: PostedImageAdapter = PostedImageAdapter()

    var presenter: HomeContract.Presenter =
        HomePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.init()
        btLogo.setOnClickListener {
            uploadData()
        }

    }

    fun uploadData() {
        val listOfItems = listOf(
            PostedItem(
                profile = UserProfile(
                    photoUri = "https://www.thispersondoesnotexist.com/image?21603152698",
                    profileLink = "123",
                    profileName = "Random Human ",
                    profilePhoto = "https://www.thispersondoesnotexist.com/image?21603152698"
                ),
                imageUri = "https://www.thispersondoesnotexist.com/image?21603152698",
                likesCount = 1,
                isLiked = true,
                timeStamp = "123 years ago",
                title = "nice photo",
                comments = listOf(
                    Comment(
                        profile = UserProfile(
                            photoUri = "https://www.thispersondoesnotexist.com/image?21603152698",
                            profileLink = "123",
                            profileName = "Random Human",
                            profilePhoto = "https://www.thispersondoesnotexist.com/image?21603152698"
                        ),
                        description = "nice",
                        commentTimeStamp = "12:32"

                    )
                )
            )
        )
        postedImageAdapter.postList = listOfItems
    }


    override fun closeApp() {
        TODO("Not yet implemented")
    }

    override fun setItems() {
        TODO("Not yet implemented")
    }

    override fun initView() {
        rvMainPosts.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = postedImageAdapter
        }
    }

    override fun updateItem() {
        TODO("Not yet implemented")
    }


}