package com.example.learneng.model.datasource

import com.example.learneng.model.data.DataModel
import io.reactivex.rxjava3.core.Single

class DataSourceRemoteImpl(private val remoteProvider: RetrofitImplementation = RetrofitImplementation()) :
    DataSource {
    override fun getData(word: String): Single<List<DataModel>> {
        return remoteProvider.getData(word)
    }
}