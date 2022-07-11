package com.example.learneng.model.repository

import com.example.learneng.model.data.DataModel


interface IRepository {
    suspend fun getData(word: String): List<DataModel>
}