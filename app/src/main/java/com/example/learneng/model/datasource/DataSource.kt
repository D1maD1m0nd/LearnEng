package com.example.learneng.model.datasource

import com.example.learneng.model.data.DataModel


// Источник данных для репозитория (Интернет, БД и т. п.)
interface DataSource {
    suspend fun getData(word: String): List<DataModel>
}