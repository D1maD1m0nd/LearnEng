package com.example.learneng.interactors

import com.example.learneng.model.data.AppState
import com.example.learneng.model.repository.IRepository


class MainInteractorImpl(
    val repo: IRepository,
) : IMainInteractor<AppState> {
    override suspend fun getData(word: String, isOnline: Boolean): AppState {
        return AppState.Success(repo.getData(word))
    }
}