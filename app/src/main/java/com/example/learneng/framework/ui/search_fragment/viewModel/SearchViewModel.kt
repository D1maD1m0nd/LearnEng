package com.example.learneng.framework.ui.search_fragment.viewModel

import androidx.lifecycle.viewModelScope
import com.example.learneng.framework.ui.base.BaseViewModel
import com.example.learneng.interactors.MainInteractorImpl
import com.example.learneng.model.data.AppState
import kotlinx.coroutines.launch

class SearchViewModel(private val interactor: MainInteractorImpl) : BaseViewModel<AppState>() {


    override fun getData(word: String, isOnline: Boolean) {
        liveDataToObserve.value = AppState.Loading(null)
        viewModelScope.launch {
            kotlin.runCatching {
                interactor.getData(word, isOnline)
            }.onSuccess {
                liveDataToObserve.postValue(interactor.getData(word, isOnline))
            }.onFailure {
                liveDataToObserve.postValue(AppState.Error(it))
            }
        }
    }


    override fun onCleared() {
        liveDataToObserve.value = AppState.Success(null)
        super.onCleared()
    }
}