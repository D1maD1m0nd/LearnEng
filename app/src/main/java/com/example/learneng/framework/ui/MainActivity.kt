package com.example.learneng.framework.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.learneng.R
import com.example.learneng.databinding.ActivityMainBinding
import com.example.learneng.framework.ui.history_fragment.HistoryFragment
import com.example.learneng.framework.ui.search_fragment.SearchFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.topAppBar.setNavigationOnClickListener {

            supportFragmentManager.popBackStack()
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_history -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(binding.fragmentContainer.id,HistoryFragment.newInstance())
                        .addToBackStack(null)
                        .commit()
                    // Handle edit text press
                    true
                }
                R.id.action_search -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(binding.fragmentContainer.id,SearchFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}