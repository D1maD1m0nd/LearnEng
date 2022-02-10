package com.example.learneng.model.repository

import com.example.learneng.model.data.DataModel
import com.example.learneng.model.datasource.DataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class RepositoryImpl(private val dataSource: DataSource) : IRepository {
    override suspend fun getData(word: String): Flow<List<DataModel>> {
        return flow {
            val data = dataSource.getData(word)
            emit(data)
        }.flowOn(Dispatchers.Default)
            .catch {
                println(it)
            }
    }
}