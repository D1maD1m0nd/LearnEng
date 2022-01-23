package com.example.learneng.model.repository

import com.example.dictionaryengapp.model.data.DataModel
import io.reactivex.Single

interface IRepository {
    fun getData(word : String) : Single<DataModel>
}