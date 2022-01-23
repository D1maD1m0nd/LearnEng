package com.example.learneng.model.repository

import com.example.dictionaryengapp.model.data.DataModel
import io.reactivex.Single

class IRepositoryImpl : IRepository {
    override fun getData(word: String): Single<DataModel> {
        TODO("Not yet implemented")
    }
}