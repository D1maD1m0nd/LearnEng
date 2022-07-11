package com.example.learneng.interactors

import com.example.learneng.model.data.AppState
import com.example.learneng.model.repository.IRepositoryLocal

class DescriptionInteractor(val repo: IRepositoryLocal) : IDescriptionInteractor {
    override suspend fun getData(id : Int): AppState {
        return AppState.Success(null, repo.getDataById(id))
    }
}