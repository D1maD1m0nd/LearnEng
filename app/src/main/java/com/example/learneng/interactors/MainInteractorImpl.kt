package com.example.learneng.interactors

import com.example.learneng.model.data.AppState
import com.example.learneng.model.repository.IRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class MainInteractorImpl(
    val repo: IRepository,
) : IMainInteractor<AppState> {
    override suspend fun getData(word: String, isOnline: Boolean): Flow<AppState> {
        return repo.getData(word).map {
            AppState.Success(it)
        }
    }
}