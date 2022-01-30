package com.example.learneng.model.repository

import com.example.learneng.model.data.DataModel
import com.example.learneng.model.datasource.DataSource
import io.reactivex.rxjava3.core.Single


class RepositoryImpl(private val dataSource: DataSource) : IRepository {
    override fun getData(word: String): Single<List<DataModel>> {
        return dataSource.getData(word)
    }
}