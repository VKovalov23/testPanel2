package com.example.myapplication.ui.home

import com.example.myapplication.utils.core.ui.BaseContract

interface HomeContract {

    interface View : BaseContract.View {
        fun setItems()
        fun initView()
        fun updateItem()
    }

    interface Presenter : BaseContract.Presenter {
        fun init()
        fun onLogoClick()
        fun onCameraClick()
        fun onMenuClick()
        fun onItemClick()
        fun onCommentClick()
    }
}