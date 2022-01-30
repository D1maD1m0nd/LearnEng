package com.example.learneng.app

import android.app.Application
import com.example.learneng.di.application
import com.example.learneng.di.searchScreen
import org.koin.core.context.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, searchScreen))
        }
    }
}