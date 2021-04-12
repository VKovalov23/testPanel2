package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        beginTransaction()
        btFavorite.setOnClickListener {
        }
        btHome.setOnClickListener {
            beginTransaction()
        }
    }

    private fun beginTransaction() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.vgFragmentContent,
                HomeFragment.newInstance()
            )
            .commit()
    }
}
