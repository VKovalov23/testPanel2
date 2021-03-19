package com.example.myapplication.ui

interface BaseContract {

    interface View {
        fun setItems()
        fun initView()
        fun updateItem()
    }

    interface Presenter {
        fun init()
        fun onLogoClick()
        fun onCameraClick()
        fun onMenuClick()
        fun onItemClick()
        fun onCommentClick()
    }
}