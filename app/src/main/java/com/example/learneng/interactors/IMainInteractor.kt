package com.example.learneng.interactors

import com.example.learneng.model.data.AppState
import kotlinx.coroutines.flow.Flow


interface IMainInteractor<T : AppState> {
    suspend fun getData(word: String, isOnline: Boolean): Flow<T>
}