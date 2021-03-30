package com.example.myapplication.utils.core.ui

interface BaseContract {


    interface View {
        fun closeApp()
    }


    interface Presenter {
        fun onLogOutClick()
    }
}

