package com.example.learneng.model.datasource

import com.example.learneng.model.data.AppState

interface DataSourceLocal : DataSource {
    suspend fun saveToDB(appState: AppState)
}