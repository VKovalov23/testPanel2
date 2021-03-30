package com.example.myapplication.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.ui.home.recycler.PostedImageAdapter
import kotlinx.android.synthetic.main.fragment_main.*

class HomeFragment : Fragment(), HomeContract.View {

   var postedImageAdapter: PostedImageAdapter = PostedImageAdapter(

   )

    var presenter: HomeContract.Presenter =
        HomePresenter(this)

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment()

        const val IDENT = "MainFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.init()
        rvMainPosts.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = postedImageAdapter
        }
    }


    override fun closeApp() {
        TODO("Not yet implemented")
    }

    override fun setItems() {
        TODO("Not yet implemented")
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun updateItem() {
        TODO("Not yet implemented")
    }


}