package com.example.learneng.interactors

import com.example.learneng.model.data.AppState


interface IMainInteractor<T : AppState> {
    suspend fun getData(word: String, isDb: Boolean): T
}