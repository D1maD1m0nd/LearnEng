package com.example.learneng.framework.ui.history_fragment.viewModel

import androidx.lifecycle.viewModelScope
import com.example.learneng.framework.ui.base.BaseViewModel
import com.example.learneng.interactors.IHistoryInteractor
import com.example.learneng.interactors.IMainInteractor
import com.example.learneng.model.data.AppState
import kotlinx.coroutines.launch

class HistoryViewModel(val interactor : IHistoryInteractor) : BaseViewModel<AppState>() {
    override fun getData(word: String, isOnline: Boolean) {
    }

    override fun getData(id: Int) {
    }

    fun getHistory() {
        viewModelScope.launch {
            kotlin.runCatching {
                interactor.getHistory()
            }.onSuccess {
                liveDataToObserve.postValue(it)
            }.onFailure {
                liveDataToObserve.postValue(AppState.Error(it))
            }
        }
    }
}