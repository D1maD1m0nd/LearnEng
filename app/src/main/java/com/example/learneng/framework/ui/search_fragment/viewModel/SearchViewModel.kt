package com.example.learneng.framework.ui.search_fragment.viewModel

import androidx.lifecycle.viewModelScope
import com.example.learneng.framework.ui.base.BaseViewModel
import com.example.learneng.interactors.MainInteractorImpl
import com.example.learneng.model.data.AppState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class SearchViewModel(private val interactor: MainInteractorImpl) : BaseViewModel<AppState>() {


    override fun getData(word: String, isOnline: Boolean) {
        liveDataToObserve.value = AppState.Loading(null)
        viewModelScope.launch {
            interactor.getData(word, isOnline)
                .flowOn(Dispatchers.Main)
                .collect {
                    liveDataToObserve.value = it
                }
        }
    }


    override fun onCleared() {
        liveDataToObserve.value = AppState.Success(null)
        super.onCleared()
    }
}