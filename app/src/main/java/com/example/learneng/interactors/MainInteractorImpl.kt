package com.example.learneng.interactors

import com.example.learneng.model.data.AppState
import com.example.learneng.model.repository.IRepository
import com.example.learneng.model.repository.IRepositoryLocal


class MainInteractorImpl(
    val repo: IRepository,
    val repoLocal: IRepositoryLocal,
) : IMainInteractor<AppState> {
    override suspend fun getData(word: String, isDb: Boolean): AppState {

        val state = AppState.Success(repo.getData(word))
        repoLocal.saveToDB(state)
        return state
    }
}