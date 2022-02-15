package com.example.learneng.model.datasource

import com.example.learneng.utils.convertToHistoryEntity
import com.example.learneng.model.data.AppState
import com.example.learneng.model.data.DataModel
import com.example.learneng.room.HistoryDao
import com.example.learneng.utils.convertToDataModel

class DataSourceLocalImpl(private val dao: HistoryDao) : DataSourceLocal {
    override suspend fun saveToDB(appState: AppState) {
        appState.convertToHistoryEntity()?.let {
            dao.insertAll(it)
        }
    }

    override suspend fun getData(word: String): List<DataModel> {
        val list = dao.all()
        return list.map {
            it.convertToDataModel()
        }
    }
}