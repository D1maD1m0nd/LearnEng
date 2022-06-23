package com.example.learneng.interactors

import com.example.learneng.model.data.AppState
import com.example.learneng.model.repository.IRepository
import com.example.learneng.model.repository.IRepositoryLocal

class HistoryInteractorImpl(
    private val repo: IRepositoryLocal
) : IHistoryInteractor {
    override suspend fun getHistory(): AppState {
        return AppState.Success(repo.getData(""))
    }
}