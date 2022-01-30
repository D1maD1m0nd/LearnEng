package com.example.dictionaryengapp.interactors

import com.example.learneng.model.data.DataModel
import io.reactivex.rxjava3.core.Single


interface IMainInteractor {
    fun getData(word : String) : Single<List<DataModel>>
}