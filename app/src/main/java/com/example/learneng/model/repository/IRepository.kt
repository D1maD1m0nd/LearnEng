package com.example.learneng.model.repository

import com.example.learneng.model.data.DataModel
import kotlinx.coroutines.flow.Flow


interface IRepository {
    suspend fun getData(word: String): Flow<List<DataModel>>
}