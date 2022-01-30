package com.example.learneng.interactors

import com.example.learneng.model.data.AppState
import com.example.learneng.model.repository.IRepository
import io.reactivex.rxjava3.core.Single


class MainInteractorImpl (
    val repo: IRepository,
    ) : IMainInteractor<AppState> {
    override fun getData(word: String, isOnline: Boolean): Single<AppState> {
        return repo.getData(word).map { AppState.Success(it) }
    }
}