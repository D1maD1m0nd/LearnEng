package com.example.learneng.framework.ui.search_fragment.viewModel

import androidx.lifecycle.LiveData
import com.example.learneng.framework.ui.base.BaseViewModel
import com.example.learneng.interactors.MainInteractorImpl
import com.example.learneng.model.data.AppState

class SearchViewModel(private val interactor: MainInteractorImpl) : BaseViewModel<AppState>() {
    private var appState: AppState? = null

    override fun getData(word: String, isOnline: Boolean): LiveData<AppState> {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io)
                .observeOn(schedulerProvider.ui)
                .doOnSubscribe { liveDataToObserve.value = AppState.Loading(null) }
                .subscribe({
                    appState = it
                    liveDataToObserve.value = it
                },
                    { liveDataToObserve.value = AppState.Error(it) })

        )
        return super.getData(word, isOnline)
    }
}