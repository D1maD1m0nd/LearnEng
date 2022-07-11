package com.example.learneng.model.datasource

import com.example.learneng.model.data.DataModel

class DataSourceRemoteImpl(private val remoteProvider: RetrofitImplementation = RetrofitImplementation()) :
    DataSource {
    override suspend fun getData(word: String): List<DataModel> {
        return remoteProvider.getData(word)
    }
}