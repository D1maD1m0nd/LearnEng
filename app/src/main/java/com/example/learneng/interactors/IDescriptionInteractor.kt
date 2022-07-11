package com.example.learneng.interactors

import com.example.learneng.model.data.AppState

interface IDescriptionInteractor {
    suspend fun getData(id : Int): AppState
}