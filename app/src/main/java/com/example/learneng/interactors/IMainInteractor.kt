package com.example.learneng.interactors

import com.example.learneng.model.data.AppState
import com.example.learneng.model.data.DataModel
import io.reactivex.rxjava3.core.Single


interface IMainInteractor<T> {
    fun getData(word : String, isOnline : Boolean) : Single<T>
}