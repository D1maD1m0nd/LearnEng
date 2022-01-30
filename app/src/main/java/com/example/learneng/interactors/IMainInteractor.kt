package com.example.learneng.interactors

import io.reactivex.rxjava3.core.Single


interface IMainInteractor<T> {
    fun getData(word: String, isOnline: Boolean): Single<T>
}