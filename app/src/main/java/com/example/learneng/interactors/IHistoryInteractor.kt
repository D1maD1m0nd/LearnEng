package com.example.learneng.interactors

import com.example.learneng.model.data.AppState

interface IHistoryInteractor {
    suspend fun getHistory() : AppState
}