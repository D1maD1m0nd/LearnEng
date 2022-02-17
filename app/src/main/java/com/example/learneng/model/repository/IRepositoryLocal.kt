package com.example.learneng.model.repository

import com.example.learneng.model.data.AppState
import com.example.learneng.model.data.DataModel

interface IRepositoryLocal : IRepository{
    suspend fun saveToDB(appState: AppState)
    suspend fun getDataById(id : Int) : DataModel
}