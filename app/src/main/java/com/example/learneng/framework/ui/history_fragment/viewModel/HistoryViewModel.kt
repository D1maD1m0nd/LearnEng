package com.example.learneng.framework.ui.history_fragment.viewModel

import com.example.learneng.framework.ui.base.BaseViewModel
import com.example.learneng.interactors.IMainInteractor
import com.example.learneng.model.data.AppState

class HistoryViewModel(interactor : IMainInteractor<AppState>) : BaseViewModel<AppState>() {
    override fun getData(word: String, isOnline: Boolean) {
        TODO("Not yet implemented")
    }
}