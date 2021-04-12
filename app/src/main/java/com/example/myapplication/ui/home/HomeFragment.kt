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
        fun newInstance() = HomeFragment()
        const val IDENT = "HomeFragment"
    }

    var postedImageAdapter: PostedImageAdapter = PostedImageAdapter()

    var presenter: HomeContract.Presenter = HomePresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.init()
    }

    override fun initView() {
        rvMainPosts.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = postedImageAdapter
        }
    }

    override fun setItems(items: List<PostedItem>) {
        postedImageAdapter.postList = items
    }

    override fun updateItem() {
        TODO("Not yet implemented")
    }

    override fun closeApp() {
        TODO("Not yet implemented")
    }

}