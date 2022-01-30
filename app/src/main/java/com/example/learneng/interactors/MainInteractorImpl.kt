package com.example.learneng.interactors

import com.example.learneng.di.NAME_REMOTE
import com.example.learneng.model.data.AppState
import com.example.learneng.model.data.DataModel
import com.example.learneng.model.repository.IRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Named


class MainInteractorImpl@Inject constructor(
    @Named(NAME_REMOTE) val repo: IRepository,

) : IMainInteractor<AppState> {
    override fun getData(word: String, isOnline: Boolean): Single<AppState> {
        return repo.getData(word).map { AppState.Success(it) }
    }
}