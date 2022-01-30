package com.example.learneng.model.repository

import com.example.learneng.model.data.DataModel
import io.reactivex.rxjava3.core.Single


interface IRepository {
    fun getData(word: String): Single<List<DataModel>>
}