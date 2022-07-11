package com.example.learneng.model.datasource

import com.example.learneng.model.data.AppState
import com.example.learneng.model.data.DataModel

interface DataSourceLocal : DataSource {
    suspend fun saveToDB(appState: AppState)
    suspend fun getDataById(id : Int) : DataModel
}