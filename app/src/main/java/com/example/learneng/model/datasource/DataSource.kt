package com.example.learneng.model.datasource

import com.example.learneng.model.data.DataModel
import io.reactivex.rxjava3.core.Single


// Источник данных для репозитория (Интернет, БД и т. п.)
interface DataSource {
    fun getData(word: String): Single<List<DataModel>>
}