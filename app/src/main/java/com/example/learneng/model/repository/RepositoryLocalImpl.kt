package com.example.learneng.model.repository

import com.example.learneng.model.data.AppState
import com.example.learneng.model.data.DataModel
import com.example.learneng.model.datasource.DataSourceLocal

class RepositoryLocalImpl(private val dataSource: DataSourceLocal) : IRepositoryLocal {
    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}