package com.example.learneng.di

import android.content.Context
import com.example.learneng.App.App
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Singleton
    @Provides
    fun app(): Context {
        return app
    }
}