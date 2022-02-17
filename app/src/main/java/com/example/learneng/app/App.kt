package com.example.learneng.app

import android.app.Application
import com.example.learneng.di.application
import com.example.learneng.di.descriptionScreen
import com.example.learneng.di.searchScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(application, searchScreen, descriptionScreen))
        }
    }
}