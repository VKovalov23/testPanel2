package com.example.myapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btFavorite.setOnClickListener {
            beginTransaction()
        }
    }

    private fun beginTransaction() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.vgFragmentContent,
                HomeFragment()
            )
            .commit()
    }
}
