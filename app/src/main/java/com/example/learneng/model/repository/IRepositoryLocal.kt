package com.example.learneng.model.repository

import com.example.learneng.model.data.AppState

interface IRepositoryLocal : IRepository{
    suspend fun saveToDB(appState: AppState)
}