package com.example.learneng.model.repository

import com.example.learneng.model.data.DataModel
import com.example.learneng.model.datasource.DataSource


class RepositoryImpl(private val dataSource: DataSource) : IRepository {
    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}