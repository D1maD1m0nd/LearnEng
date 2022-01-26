package com.example.learneng.framework.ui.search_fragment.viewModel

import androidx.lifecycle.LiveData
import com.example.learneng.interactors.IMainInteractor
import com.example.learneng.framework.ui.base.BaseViewModel
import com.example.learneng.interactors.MainInteractorImpl
import com.example.learneng.model.data.AppState
import com.example.learneng.model.datasource.DataSourceRemoteImpl
import com.example.learneng.model.repository.RepositoryImpl
import io.reactivex.rxjava3.observers.DisposableObserver

class SearchViewModel (
    private val interactor : IMainInteractor<AppState> = MainInteractorImpl(
        RepositoryImpl(DataSourceRemoteImpl())
    )) : BaseViewModel<AppState>() {
    private var appState : AppState? = null

    override fun getData(word: String, isOnline: Boolean): LiveData<AppState> {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io)
                .observeOn(schedulerProvider.ui)
                .doOnSubscribe{ liveDataToObserve.value = AppState.Loading(null) }
                .subscribe({ appState = it
                            liveDataToObserve.value = it},
                         {liveDataToObserve.value = AppState.Error(it)})

        )
        return super.getData(word, isOnline)
    }
}