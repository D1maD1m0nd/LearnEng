package com.example.learneng.framework.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learneng.R
import com.example.learneng.framework.ui.search_fragment.SearchFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}